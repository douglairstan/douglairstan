@color A
@echo Fazendo Backup do Banco de Dados - Postgres
@E:
@cd E:\Arquivos de Programas\PostgreSQL v8.2\bin\
@pg_dump.exe -i -h localhost -p 5432 -U postgres -F c -b -D -v -f "C:\SGSE.backup" "SGSE"
@exit