#!/bin/bash

#######################################################################
# pontos de montagem dos diretorios
#DESTINO="/var/lib/postgres/BACKUPS"
DESTINO="/home/mauricio/scripts/postgres/BACKUPS"
# data do dump
DATADEHOJE=`date +%Y%m%d`
# opcao define se o script roda em modo interativo ou nao, com a passagem do parametro
OPCAO=${1:-"_INTERATIVO_"}

#######################################################################
# acerta o PATH
#PG_PATH="/usr/local/pgsql/bin"
PG_PATH="/usr/bin"
export PATH=$PATH:$PG_PATH:

#######################################################################
#
# funcao para executar o backup
#
#######################################################################
pgdump () {
# pgdump "S" $DATABASE $DESTINO
 # implementa o debug, nao faz nada ou executa o script...
 DEBUG=
 ECHO=""
 if [ "$DEBUG" == "1" ]
 then
   ECHO="echo "
 fi
 
 DATABASE="$2"
 DESTINO="$3"
 DATADEHOJE=`date +%Y%m%d`
 PGDUMP="pg_dump"
 if [ "$1" == "S" ]
 then
  SCHEMA_MODE=" -s -C "
  SUFIXO="estrutura"
 fi
 if [ "$1" == "D" ]
 then
  # falta testar o blob... -b 
  SCHEMA_MODE=" -a -C "
  SUFIXO="dados"
 fi
 
 # backup de todos
 if [ "$DATABASE" == "todos" ]
 then
  SCHEMA_MODE=`echo $SCHEMA_MODE|sed -e 's/ -C//g'`
  #SUFIXO="todos"
  DATABASE="todos"
  PGDUMP="pg_dump"
 fi
 
 cd
 cd $DESTINO
 # criar o diretorio de data...
 if [ ! -e "$DATADEHOJE" ]
 then
   mkdir $DATADEHOJE
 fi
 cd $DATADEHOJE
 
 ARQUIVO="${DATABASE}_${SUFIXO}.tar"
 # apaga o arquivo se ja existir
 if [ -e "$ARQUIVO" ]
 then
  echo "Ja existe o arquivo: $ARQUIVO. Removendo o traste..."
  rm -f $ARQUIVO
 fi
 
 # executa os comandos
 # se for backup de todos
 if [ "$DATABASE" == "todos" -o "$DATABASE" == "" ]
 then
   if [ -e "$ARQUIVO" ]
   then
    for DBT in `psql postgres -l --tuples-only| tr -s " "|sed -e 's/^ //g'|cut -f1 -d" "`
    do
     ARQUIVO="${DBT}.tar"
     eval "$ECHO $PGDUMP -C -Ft -U postgres -x > $ARQUIVO"
     vacuumdb $DBT
    done
    #rm -f $ARQUIVO
   fi
   eval "$ECHO $PGDUMP $SCHEMA_MODE -F t -U postgres -x > $ARQUIVO"
   chmod 600 $ARQUIVO
 else
   eval "$ECHO $PGDUMP $SCHEMA_MODE -F t -U postgres -x -f $ARQUIVO $DATABASE"
   chmod 600 $ARQUIVO
 fi


 # limpa backup antigo do mesmo dia
 if [ -e "$DATADEHOJE.tar" ]
 then
  rm -f $DATABASE.tar
 fi
 if [ -e "$DATABASE.tar.gz" ]
 then
  rm -f $DATABASE.tar.gz
 fi
 cria_tar $DATABASE $ARQUIVO

}
#######################################################################

#######################################################################
#
# cria o tar dos bancos
#
#######################################################################
function cria_tar () {

 ARQUIVOTAR=$1".tar"
 ARQUIVOINC="$2"
 touch $ARQUIVOTAR
 tar rf $ARQUIVOTAR $ARQUIVOINC
 if [ "$?" == "0" ]
 then
  rm -f $ARQUIVOINC
 fi
 chmod 600 $ARQUIVOTAR

}
#######################################################################

if [ "$OPCAO" == "_INTERATIVO_" ]
then

 #######################################################################
 # dialogo com o usuario
 #######################################################################
 DIALOG=dialog
 tempfile=`tempfile 2>/dev/null` || tempfile=/tmp/test$$
 trap "rm -f $tempfile" 0 1 2 5 15

 if [ "`whoami`" == 'postgres' ]
 then 
   TABELAS=`psql -l -t|sort|sed -e 's/ //g'|grep '[a-zA-Z]'|cut -f1  -d"|"|awk '{ printf "%s %s off ", $0, $0}'`
 else
   TABELAS=`su postgres -c "psql -l -t"|sort|sed -e 's/ //g'|grep '[a-zA-Z]'|cut -f1  -d"|"|awk '{ printf "%s %s off ", $0, $0}'`
 fi

 $DIALOG --backtitle "Portal do Voluntario" \
   --title "< BACKUP DO POSTGRES >" --clear \
   --radiolist "\nSelecione um banco para iniciar com o backup: (use ESPACO)\n\n${DESTINO}/${DATADEHOJE}" \
   20 65 10 \
   todos TODOS_ABAIXO off $TABELAS \
   2> $tempfile
 retval=$?
 DATABASE=`cat $tempfile|sed -e 's/"//g'`
 case $retval in
  0)
    # somente o esquema do banco
    pgdump "S" $DATABASE $DESTINO;
    # redefine a opcao
    DATABASE=`cat $tempfile|sed -e 's/"//g'`;
    #  somente os dados
    pgdump "D" $DATABASE $DESTINO
    gzip -9 $DATABASE.tar;;
  1)
    echo "Processo cancelado.";;
  255)
    echo "Processo cancelado.";;
 esac

else
# modo nao interativo
    pgdump "S" $OPCAO $DESTINO;
    # redefine a opcao
    #  somente os dados
    pgdump "D" $OPCAO $DESTINO
    gzip -9 $OPCAO.tar
fi


#
#######################################################################
# fim
