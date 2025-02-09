﻿-- GRUPO SANGUINIO

-- Mostra Idade
-- select extract(year from age((select current_date), (select idade from teste where id = 1)));
--########################################################################################################################################################################

CREATE OR REPLACE FUNCTION verificar_cnpj(text)
RETURNS BOOLEAN AS $$
-- se o tamanho for 14 prossiga com o cálculo
-- senão retorne falso
SELECT CASE WHEN LENGTH($1) = 14 THEN
(
  -- verifica se os dígitos coincidem com os especificados
  SELECT
      SUBSTR($1, 13, 1) = CAST(digit1 AS text) AND
      SUBSTR($1, 14, 1) = CAST(digit2 AS text)
  FROM
  (
    -- calcula o segundo dígito verificador (digit2)
    SELECT
        -- se o resultado do módulo for 0 ou 1 temos 0
        -- senão temos a subtração de 11 pelo resultado do módulo
        CASE res2
        WHEN 0 THEN 0
        WHEN 1 THEN 0
        ELSE 11 - res2
        END AS digit2,
        digit1
    FROM
    (
      -- soma da multiplicação dos primeiros 9 dígitos por 11, 10, ..., 4, 3
      -- obtemos o módulo da soma por 11
      SELECT MOD(SUM(res2) + digit1 * 2, 11) AS res2,
          digit1
      FROM
      (
        SELECT
            SUM(m * CAST(SUBSTR($1, 7 - m, 1) AS INTEGER)) AS res2
        FROM
        (
          SELECT generate_series(6, 2, -1) AS m
        ) AS m11
        UNION ALL
        SELECT
            SUM(m * CAST(SUBSTR($1, 15 - m, 1) AS INTEGER)) AS res2
        FROM
        (
          SELECT generate_series(9, 3, -1) AS m
        ) AS m12
      ) AS m2,
      (
        -- calcula o primeiro dígito verificador (digit1)
        SELECT
            -- se o resultado do módulo for 0 ou 1 temos 0
            -- senão temos a subtração de 11 pelo resultado do módulo
            CASE res1
            WHEN 0 THEN 0
            WHEN 1 THEN 0
            ELSE 11 - res1
            END AS digit1
        FROM
        (
          -- soma da multiplicação dos primeiros 12 dígitos por 5, 4, 3, 2, 9, 8, 7, ..., 3, 2
          -- obtemos o módulo da soma por 11
          SELECT MOD(SUM(res1), 11) AS res1
          FROM
          (
            SELECT
                SUM(n * CAST(SUBSTR($1, 6 - n, 1) AS INTEGER)) AS res1
            FROM
            (
              SELECT generate_series(5, 2, -1) AS n
            ) AS m11
            UNION ALL
            SELECT
                SUM(n * CAST(SUBSTR($1, 14 - n, 1) AS INTEGER)) AS res1
            FROM
            (
              SELECT generate_series(9, 2, -1) AS n
            ) AS m12
          ) AS m1
        ) AS sum1
      ) AS first_digit
      GROUP BY digit1
    ) AS sum2
  ) AS first_sec_digit
)
ELSE FALSE END;
 
$$ LANGUAGE 'SQL'
IMMUTABLE STRICT;

--########################################################################################################################################################################


CREATE OR REPLACE FUNCTION verificar_cpf(text)
RETURNS BOOLEAN AS $$
-- se o tamanho for 11 prossiga com o cálculo
-- senão retorne falso
SELECT CASE WHEN LENGTH($1) = 11 THEN
(
  -- verifica se os dígitos coincidem com os especificados
  SELECT
      SUBSTR($1, 10, 1) = CAST(digit1 AS text) AND
      SUBSTR($1, 11, 1) = CAST(digit2 AS text)
  FROM
  (
    -- calcula o segundo dígito verificador (digit2)
    SELECT
        -- se o resultado do módulo for 0 ou 1 temos 0
        -- senão temos a subtração de 11 pelo resultado do módulo
        CASE res2
        WHEN 0 THEN 0
        WHEN 1 THEN 0
        ELSE 11 - res2
        END AS digit2,
        digit1
    FROM
    (
      -- soma da multiplicação dos primeiros 9 dígitos por 11, 10, ..., 4, 3
      -- obtemos o módulo da soma por 11
      SELECT
          MOD(SUM(m * CAST(SUBSTR($1, 12 - m, 1) AS INTEGER)) + digit1 * 2, 11) AS res2,
          digit1
      FROM
      generate_series(11, 3, -1) AS m,
      (
        -- calcula o primeiro dígito verificador (digit1)
        SELECT
            -- se o resultado do módulo for 0 ou 1 temos 0
            -- senão temos a subtração de 11 pelo resultado do módulo
            CASE res1
            WHEN 0 THEN 0
            WHEN 1 THEN 0
            ELSE 11 - res1
            END AS digit1
        FROM
        (
          -- soma da multiplicação dos primeiros 9 dígitos por 10, 9, ..., 3, 2
          -- obtemos o módulo da soma por 11
          SELECT
              MOD(SUM(n * CAST(SUBSTR($1, 11 - n, 1) AS INTEGER)), 11) AS res1
          FROM generate_series(10, 2, -1) AS n
        ) AS sum1
      ) AS first_digit
      GROUP BY digit1
    ) AS sum2
  ) AS first_sec_digit
)
ELSE FALSE END;
 
$$ LANGUAGE 'SQL'
IMMUTABLE STRICT;



--########################################################################################################################################################################

-- PESSOAS

drop sequence sid_pessoa;
drop table pessoa;



create sequence sid_cor_racas;
create table cor_racas(
  cor_racas_id bigint NOT NULL primary key, 
  cor_racas_data date NOT NULL, 
  cor_racas_hora time without time zone NOT NULL, 
  cor_racas_status boolean not null,
  cor_racas_nome varchar (20) unique,
  cor_racas_descricao varchar (130)
 );

insert into cor_racas values (nextval('sid_cor_racas'),(select current_date), (select current_time), true,'','');
insert into cor_racas values (nextval('sid_cor_racas'),(select current_date), (select current_time), true,'AFRO-BRASILEIRO','PETRO, DEPOIS CHAMADO NEGRO, E ATUALMENTE AFRO-BRASILEIRO, O ESCRAVO, DIVIDIDO EM VÁRIAS RAÇAS: BANTO, BANGUELA, CONGO E MINA');
insert into cor_racas values (nextval('sid_cor_racas'),(select current_date), (select current_time), true,'BRANCO','BRANCO, O EUROPEU IMIGRADO PARA O BRASIL');
insert into cor_racas values (nextval('sid_cor_racas'),(select current_date), (select current_time), true,'NEGRO','NEGRO DA TERRA, O ÍNDIO, DIVIDIDO EM VÁRIAS NAÇÕES');
insert into cor_racas values (nextval('sid_cor_racas'),(select current_date), (select current_time), true,'CABOCLO','ORIUNDO DO CRUZAMENTO DO BRANCO COM ÍNDIO');
insert into cor_racas values (nextval('sid_cor_racas'),(select current_date), (select current_time), true,'CAFUZ','OU CAFUZO, ORIUNDO DO CRUZAMENTO DO ÍNDIO COM O NEGRO');
insert into cor_racas values (nextval('sid_cor_racas'),(select current_date), (select current_time), true,'CABRA','ORIUNDO DO CRUZAMENTO DO MULATO COM NEGRO');



create sequence sid_sexo;
create table sexo(
  sexo_id bigint primary key,
  sexo_data date not null,
  sexo_hora time without time zone not null,
  sexo_status boolean not null, 
  sexo_tipo varchar (2) unique,
  sexo_descricao varchar(50)
);

insert into sexo values (nextval('sid_sexo'),(select current_date), (select current_time), true,'M','MASCULINO');
insert into sexo values (nextval('sid_sexo'),(select current_date), (select current_time), true,'F','FEMININO');

--select p.pessoa_ci_uf, p.pessoa_ci_numero, p.pessoa_nome, p.pessoa_dn, p.pessoa_sexo, p.pessoa_nascimento_multiplo from pessoa p, registro_pessoa_empresa rpe where (p.pessoa_ci_uf = rpe.pessoa_ci_uf and p.pessoa_ci_numero = rpe.pessoa_ci_numero) and p.pessoa_status = true and rpe.rpe_status = true and rpe.empresa_cnpj = '01611213000112' and p.pessoa_sexo = 'M' order by p.pessoa_nome



create sequence sid_agnome;
create table agnome(
  agnome_id bigint NOT NULL primary key,
  agnome_data date NOT NULL,
  agnome_hora time without time zone NOT NULL,
  agnome_status boolean,
  agnome_nome varchar(50) not null unique,
  agnome_descricao varchar
);  

insert into agnome values (nextval('sid_agnome'),(select current_date), (select current_time), true,'','');
insert into agnome values (nextval('sid_agnome'),(select current_date), (select current_time), true,' ','');
insert into agnome values (nextval('sid_agnome'),(select current_date), (select current_time), true,'FILHO','');
insert into agnome values (nextval('sid_agnome'),(select current_date), (select current_time), true,'NETO','');
insert into agnome values (nextval('sid_agnome'),(select current_date), (select current_time), true,'JUNIOR','');
insert into agnome values (nextval('sid_agnome'),(select current_date), (select current_time), true,'SOBRINHO','');
insert into agnome values (nextval('sid_agnome'),(select current_date), (select current_time), true,'I','');
insert into agnome values (nextval('sid_agnome'),(select current_date), (select current_time), true,'II','');



create sequence sid_estado_civil;
create table estado_civil(
  estado_civil_id bigint NOT NULL primary key,
  estado_civil_data date NOT NULL,
  estado_civil_hora time without time zone NOT NULL,
  estado_civil_status boolean,
  estado_civil_nome varchar(30) not null unique,
  estado_civil_descricao varchar
);  

insert into estado_civil values (nextval('sid_agnome'),(select current_date), (select current_time), true,'','');
insert into estado_civil values (nextval('sid_agnome'),(select current_date), (select current_time), true,' ','');
insert into estado_civil values (nextval('sid_agnome'),(select current_date), (select current_time), true,'CASADO(A)','');
insert into estado_civil values (nextval('sid_agnome'),(select current_date), (select current_time), true,'SOLTEIRO(A)','');
insert into estado_civil values (nextval('sid_agnome'),(select current_date), (select current_time), true,'VIÚVO(A)','');
insert into estado_civil values (nextval('sid_agnome'),(select current_date), (select current_time), true,'AMACIADO(A)','');


-- Pessoa
create sequence sid_pessoa;
create table pessoa(
  pessoa_id bigint NOT NULL,
  pessoa_data date NOT NULL,
  pessoa_hora time without time zone NOT NULL,
  pessoa_status boolean,
  pessoa_ci_tipo varchar(10),
  pessoa_ci_uf varchar(5) NOT NULL,
  pessoa_ci_numero varchar(20) NOT NULL,
  pessoa_prenome varchar(200) NOT NULL,
  pessoa_sobrenome varchar(50),
  pessoa_agnome varchar(50) references agnome (agnome_nome),
  pessoa_nome varchar(300),
  pessoa_dn date,
  pessoa_sexo varchar(2) references sexo (sexo_tipo),
  pessoa_cor varchar(20) references cor_racas (cor_racas_nome),
  pessoa_estado_civil varchar(30) references estado_civil (estado_civil_nome),
  pessoa_nascimento_multiplo varchar(20) references nascimento_multiplo (nascimento_multiplo_tipo),
  constraint pk_pessoa_ci_uf_id primary key (pessoa_ci_uf, pessoa_ci_numero)
);

insert into pessoa values (nextval('sid_pessoa'),(select current_date), (select current_time), true,'RG','SP','402265506','DOUGLAS ESTANISLAU','PEREIRA','','DOUGLAS ESTANISLAU PEREIRA','1987-10-17','M','BRANCO','CASADO','UNICO');

create table pessoa_fisica(
    pf_id bigint not null,
    pf_data date not null,
    pf_hora time without time zone not null,
    pf_status boolean,
    pf_cpf varchar(11) not null primary key,
    pf_nome varchar(100) not null,
    pf_dn date,
    pf_sexo varchar(2) references sexo (sexo_tipo),
    pf_cor varchar(20) references cor_racas (cor_racas_nome)
);

create sequence sid_pessoa_senha;
create table pessoa_senha(
  pessoa_senha_id bigint NOT NULL primary key,
  pessoa_senha_data date NOT NULL,
  pessoa_senha_hora time without time zone NOT NULL,
  pessoa_senha_status boolean not null,
  pessoa_ci_uf varchar(5) not null,--SP
  pessoa_ci_numero varchar(20) not null,--402265506
  empresa_cnpj varchar(20) not null references empresa (empresa_cnpj), --01611213000112
  pessoa_login varchar(30) not null unique,--douglairstan
  pessoa_senha varchar(32) not null,--senha
  constraint fk_senha_pessoa_ci_uf_id FOREIGN KEY (pessoa_ci_uf, pessoa_ci_numero)
      REFERENCES pessoa (pessoa_ci_uf, pessoa_ci_numero) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint uq_pessoa_uf_numero unique (pessoa_ci_uf, pessoa_ci_numero, empresa_cnpj, pessoa_login)
);

insert into pessoa_senha values (nextval('sid_pessoa_senha'),(select current_date), (select current_time),true,'SP','402265506','01611213000112','douglairstan','e10adc3949ba59abbe56e057f20f883e');
insert into pessoa_senha values (nextval('sid_pessoa_senha'),(select current_date), (select current_time),true,'SP','420453209','01611213000112','cintiasp','74a09ec596760f91794333f545e0dda');
			  
--select count(*) as verificador from pessoa_senha where pessoa_ci_uf = 'SP' and pessoa_ci_numero = '402265506' and empresa_cnpj = '01611213000112' and pessoa_senha_status = true

create sequence sid_pessoa_religiao;
create table pessoa_religiao(
  pessoa_religiao_id bigint NOT NULL primary key,
  pessoa_religiao_data date NOT NULL,
  pessoa_religiao_hora time without time zone NOT NULL,
  pessoa_religiao_status boolean not null,
  pessoa_ci_uf varchar(5) not null,--SP
  pessoa_ci_numero varchar(20) not null,--402265506,
  pessoa_religiao_nome varchar(50) references religiao(religiao_nome),
  pessoa_religiao_obs varchar(100),
  constraint fk_pessoa_religiao foreign key (pessoa_ci_uf, pessoa_ci_numero)
      REFERENCES pessoa (pessoa_ci_uf, pessoa_ci_numero) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

insert into pessoa_religiao values (nextval('sid_pessoa_religiao'),(select current_date), (select current_time),true,'SP','402265506','CONGREGAÇÃO CRISTÃ NO BRASIL','');
--select pr.pessoa_religiao_id, pr.pessoa_religiao_data, pr.pessoa_religiao_nome, pr.pessoa_religiao_obs from pessoa pe, pessoa_religiao pr where pr.pessoa_religiao_status = true and pe.pessoa_status = true and (pe.pessoa_ci_uf, pe.pessoa_ci_numero) = (pr.pessoa_ci_uf, pr.pessoa_ci_numero) and pe.pessoa_ci_uf = 'SP' and pe.pessoa_ci_numero = '402265506' order by pessoa_religiao_id desc

--########################################################################################################################################################################


-- Registro de Pessoa na Empresa

--drop sequence sid_registro_pessoa_empresa;
--drop table registro_pessoa_empresa;



create sequence sid_empresa_cargo;
create table empresa_cargo(
  empresa_cargo_id bigint NOT NULL primary key,
  empresa_cargo_data date NOT NULL,
  empresa_cargo_hora time without time zone NOT NULL,
  empresa_cargo_status boolean,
  empresa_cnpj varchar(20) not null references empresa (empresa_cnpj),
  empresa_cargo_nome varchar(50) not null,
  constraint uq_empresa_cargo unique (empresa_cnpj, empresa_cargo_nome)
);

insert into empresa_cargo values (nextval('sid_empresa_cargo'),(select current_date), (select current_time),true,'01611213000112','ALUNO(A)');
insert into empresa_cargo values (nextval('sid_empresa_cargo'),(select current_date), (select current_time),true,'01611213000112','PROFESSOR(A)');
insert into empresa_cargo values (nextval('sid_empresa_cargo'),(select current_date), (select current_time),true,'01611213000112','SECRETARIO(A)');
insert into empresa_cargo values (nextval('sid_empresa_cargo'),(select current_date), (select current_time),true,'01611213000112','DIRETOR(A)');
insert into empresa_cargo values (nextval('sid_empresa_cargo'),(select current_date), (select current_time),true,'01611213000112','COORDENADOR(A)');
insert into empresa_cargo values (nextval('sid_empresa_cargo'),(select current_date), (select current_time),true,'01611213000112','VICE-DIRETOR(A)');
insert into empresa_cargo values (nextval('sid_empresa_cargo'),(select current_date), (select current_time),true,'01611213000112','AUXILIAR DOCENTE');




create sequence sid_empresa_cargo_funcao;
create table empresa_cargo_funcao(
  empresa_cf_id bigint NOT NULL primary key,
  empresa_cf_data date NOT NULL,
  empresa_cf_hora time without time zone NOT NULL,
  empresa_cf_status boolean,
  empresa_cnpj varchar(20) not null references empresa (empresa_cnpj),
  empresa_cargo_nome varchar(50) not null, --references empresa_cargo (empresa_cargo_nome),
  empresa_cf_nome varchar(50),
  constraint uq_empresa_cargo_funcao unique (empresa_cnpj, empresa_cargo_nome, empresa_cf_nome)
);

insert into empresa_cargo_funcao values (nextval('sid_empresa_cargo_funcao'),(select current_date), (select current_time),true,'01611213000112','ALUNO(A)','');
insert into empresa_cargo_funcao values (nextval('sid_empresa_cargo_funcao'),(select current_date), (select current_time),true,'01611213000112','PROFESSOR(A)','PEB I');
insert into empresa_cargo_funcao values (nextval('sid_empresa_cargo_funcao'),(select current_date), (select current_time),true,'01611213000112','PROFESSOR(A)','PEB II');
insert into empresa_cargo_funcao values (nextval('sid_empresa_cargo_funcao'),(select current_date), (select current_time),true,'01611213000112','PROFESSOR(A)','INFORMATICA');



create sequence sid_registro_pessoa_empresa;
create table registro_pessoa_empresa(
  rpe_id bigint NOT NULL primary key,
  rpe_data date NOT NULL,
  rpe_hora time without time zone NOT NULL,
  rpe_status boolean,
  rpe_registro int not null,
  empresa_cnpj varchar(20) not null references empresa (empresa_cnpj),
  pessoa_ci_uf varchar(5) not null,
  pessoa_ci_numero varchar(20) not null,
  cargo_nome varchar(50) not null,
  funcao_nome varchar(50),
  constraint uq_rpe_registro_empresa_sp_ci unique (rpe_registro, empresa_cnpj, pessoa_ci_uf, pessoa_ci_numero),
  constraint fk_registro_pessoa_ci_uf_id FOREIGN KEY (pessoa_ci_uf, pessoa_ci_numero)
      REFERENCES pessoa (pessoa_ci_uf, pessoa_ci_numero) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION 
);

insert into registro_pessoa_empresa values (nextval('sid_registro_pessoa_empresa'),(select current_date), (select current_time),true,1,'01611213000112','SP','402265506','PROFESSOR(A)','INFORMÁTICA');
--select rpe_registro,  count(*) from registro_pessoa_empresa group by rpe_registro order by 2 desc, 1 desc


--#########################################################################################################################################################################


create sequence sid_certidao_civil;
create table certidao_civil(
  certidao_civil_id bigint primary key,
  certidao_civil_data date not null,
  certidao_civil_hora time without time zone not null,
  certidao_civil_status boolean not null,
  certidao_civil_codigo int unique, 
  certidao_civil_tipo varchar (10) unique,
  certidao_descricao varchar(50)
);

insert into certidao_civil values (nextval('sid_certidao_civil'),(select current_date), (select current_time), true,'1','CN','CERTIDAO DE NASCIMENTO');
insert into certidao_civil values (nextval('sid_certidao_civil'),(select current_date), (select current_time), true,'2','CC','CERTIDAO DE CASAMENTO');
--insert into certidao values (nextval('sid_certidao'),(select current_date), (select current_time), true,'','');

--########################################################################################################################################################################

create sequence sid_nascimento_multiplo;
create table nascimento_multiplo(
  nascimento_multiplo_id bigint primary key,
  nascimento_multiplo_data date not null,
  nascimento_multiplo_hora time without time zone not null,
  nascimento_multiplo_status boolean not null,
  nascimento_multiplo_codigo int unique, 
  nascimento_multiplo_tipo varchar (20) unique,
  nascimento_multiplo_descricao varchar(50)
);

insert into nascimento_multiplo values (nextval('sid_nascimento_multiplo'),(select current_date), (select current_time), true,'1','UNICO','NASCIMENTO DE 1 CRIANÇAS POR GESTAÇÃO');
insert into nascimento_multiplo values (nextval('sid_nascimento_multiplo'),(select current_date), (select current_time), true,'2','GEMEOS','NASCIMENTO DE 2 CRIANÇAS POR GESTAÇÃO');
insert into nascimento_multiplo values (nextval('sid_nascimento_multiplo'),(select current_date), (select current_time), true,'3','TRIGEMEOS','NASCIMENTO DE 3 CRIANÇAS POR GESTAÇÃO');
insert into nascimento_multiplo values (nextval('sid_nascimento_multiplo'),(select current_date), (select current_time), true,'4','QUADRIGEMEOS','NASCIMENTO DE 4 CRIANÇAS POR GESTAÇÃO');

--select p.pessoa_ci_uf, p.pessoa_ci_numero, p.pessoa_nome, p.pessoa_dn, p.pessoa_sexo, p.pessoa_nascimento_multiplo from pessoa p, registro_pessoa_empresa rpe where (p.pessoa_ci_uf = rpe.pessoa_ci_uf and p.pessoa_ci_numero = rpe.pessoa_ci_numero) and p.pessoa_status = true and rpe.rpe_status = true and rpe.empresa_cnpj = '01611213000112' and p.pessoa_nascimento_multiplo <> 'UNICO' order by p.pessoa_nome

--########################################################################################################################################################################

create sequence sid_orgaoemissor;
create table orgaoemissor(
  orgaoemissor_id bigint primary key,
  orgaoemissor_data date not null,
  orgaoemissor_hora time without time zone not null,
  orgaoemissor_status boolean not null,
  uf_nome varchar(5) not null,-- references uf (uf_nome),
  orgaoemissor_nome varchar (10) not null,
  orgaoemissor_descricao varchar(50)
  constraint uq_uf_nome_oe_nome unique (uf_nome, orgaoemissor_nome) 
);

insert into orgaoemissor values (nextval('sid_orgaoemissor'),(select current_date), (select current_time), true,'','','');
insert into orgaoemissor values (nextval('sid_orgaoemissor'),(select current_date), (select current_time), true,'SP','SSP','SECRETARIA DA SEGURANÇA PUBLICA DO ESTADO DE SÃO PAULO');


--########################################################################################################################################################################

-- ENDEREÇO


drop sequence sid_logradouro;
drop table logradouro;

drop sequence sid_bairro;
drop table bairro;

drop sequence sid_zona;
drop table zona;

drop sequence sid_cep;
drop table cep;

drop sequence sid_cidade;
drop table cidade;

drop sequence sid_uf;
drop table uf;

drop sequence sid_pais;
drop table pais;

drop sequence sid_continente;
drop table continente;




create sequence sid_continente;
create table continente(
  continente_id bigint primary key,
  continente_data date not null,
  continente_hora time without time zone not null,
  continente_status boolean not null, 
  continente_nome varchar (30) unique,
  continente_descricao varchar(100)
);

insert into continente values (nextval('sid_continente'),(select current_date), (select current_time), true,'','');
insert into continente values (nextval('sid_continente'),(select current_date), (select current_time), true,'AMÉRICA DO NORTE','');
insert into continente values (nextval('sid_continente'),(select current_date), (select current_time), true,'AMÉRICA DO SUL','');
insert into continente values (nextval('sid_continente'),(select current_date), (select current_time), true,'ÁSIA','');
insert into continente values (nextval('sid_continente'),(select current_date), (select current_time), true,'EUROPA','');
insert into continente values (nextval('sid_continente'),(select current_date), (select current_time), true,'ÁFRICA','');
insert into continente values (nextval('sid_continente'),(select current_date), (select current_time), true,'AUSTRALIA','');
insert into continente values (nextval('sid_continente'),(select current_date), (select current_time), true,'ANTARTIDA','');



create sequence sid_pais;
create table pais(
  pais_id bigint primary key,
  pais_data date not null,
  pais_hora time without time zone not null,
  pais_status boolean not null, 
  continente_nome varchar(30) references continente(continente_nome),
  pais_nome varchar (50) unique,
  pais_descricao varchar(100)
);

insert into pais values (nextval('sid_pais'),(select current_date), (select current_time), true,'','','');
insert into pais values (nextval('sid_pais'),(select current_date), (select current_time), true,'AMÉRICA DO SUL','BRASIL','');



create sequence sid_uf;
create table uf(
  uf_id bigint primary key,
  uf_data date not null,
  uf_hora time without time zone not null,
  uf_status boolean not null,
  pais_nome varchar(50) not null,-- references pais (pais_nome),
  uf_nome varchar (10),
  uf_descricao varchar(100),
  constraint uq_pais_uf unique (pais_nome, uf_nome) 
);

insert into uf values (nextval('sid_uf'),(select current_date), (select current_time), true,'','','');
insert into uf values (nextval('sid_uf'),(select current_date), (select current_time), true,'BRASIL','SP','SÃO PAULO');
insert into uf values (nextval('sid_uf'),(select current_date), (select current_time), true,'BRASIL','MG','MINAS GERAIS');



create sequence sid_cidade;
create table cidade(
  cidade_id bigint primary key,
  cidade_data date not null,
  cidade_hora time without time zone not null,
  cidade_status boolean not null, 
  pais_nome varchar(50) not null,-- references pais (pais_nome),
  uf_nome varchar (10) not null,
  cidade_nome varchar (50),
  constraint uq_pais_uf_cidade unique (pais_nome, uf_nome, cidade_nome)  
);

insert into cidade values (nextval('sid_cidade'),(select current_date), (select current_time), true,'BRASIL','SP','FERNANDÓPOLIS');
insert into cidade values (nextval('sid_cidade'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE');



create sequence sid_cep;
create table cep(
  cep_id bigint primary key,
  cep_data date not null,
  cep_hora time without time zone not null,
  cep_status boolean not null,
  pais_nome varchar(50) not null references pais (pais_nome),
  uf_nome varchar (10) not null,-- references uf (uf_nome),
  cidade_nome varchar (50) not null,-- references cidade (cidade_nome),
  cep_numero varchar(30) not null,
  constraint uq_pais_uf_cidadecep unique (pais_nome, uf_nome, cidade_nome, cep_numero) 
);

insert into cep values (nextval('sid_cep'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000');



create sequence sid_zona;
create table zona(
  zona_id bigint primary key,
  zona_data date not null,
  zona_hora time without time zone not null,
  zona_status boolean not null,
  pais_nome varchar(50) not null references pais (pais_nome),
  uf_nome varchar (10) not null,
  cidade_nome varchar (50) not null,
  cep_numero varchar(30) not null, 
  zona_nome varchar (20) not null,
  constraint uq_pais_uf_cidade_cep_zona unique (pais_nome, uf_nome, cidade_nome, cep_numero, zona_nome) 
);

insert into zona values (nextval('sid_zona'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA');
insert into zona values (nextval('sid_zona'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','RURAL');



create sequence sid_bairro;
create table bairro(
  bairro_id bigint primary key,
  bairro_data date not null,
  bairro_hora time without time zone not null,
  bairro_status boolean not null,
  pais_nome varchar(30) not null references pais (pais_nome),
  uf_nome varchar (10) not null,-- references uf (uf_nome),
  cidade_nome varchar (50) not null,-- references cidade (cidade_nome),
  cep_numero varchar(30) not null,
  zona_nome varchar(20) not null,
  bairro_nome varchar(150) not null,
  constraint uq_pais_uf_cidade_cep_zona_bairro unique (pais_nome, uf_nome, cidade_nome, cep_numero, zona_nome, bairro_nome)  
);

insert into bairro values (nextval('sid_bairro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','','');
insert into bairro values (nextval('sid_bairro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','CENTRO');
insert into bairro values (nextval('sid_bairro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','JD. SARINHA');
insert into bairro values (nextval('sid_bairro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','JD. SARINHA II');
insert into bairro values (nextval('sid_bairro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','JD. SARINHA III');
insert into bairro values (nextval('sid_bairro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','JD. DO BOSQUE');
insert into bairro values (nextval('sid_bairro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','JD. DAS FLORES');
insert into bairro values (nextval('sid_bairro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','JD. BELA VISTA');
insert into bairro values (nextval('sid_bairro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','JD. SÃO LORENÇO');
insert into bairro values (nextval('sid_bairro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','JD. SÃO LORENÇO II');
insert into bairro values (nextval('sid_bairro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','JD. SÃO LORENÇO III');
insert into bairro values (nextval('sid_bairro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','RES. RODRIGUES');



create sequence sid_logradouro;
create table logradouro(
  logradouro_id bigint primary key,
  logradouro_data date not null,
  logradouro_hora time without time zone not null,
  logradouro_status boolean not null,
  pais_nome varchar(30) not null references pais (pais_nome),
  uf_nome varchar (10) not null,-- references uf (uf_nome),
  cidade_nome varchar (50) not null,-- references cidade (cidade_nome),
  cep_numero varchar(30) not null,
  zona_nome varchar(30) not null,
  bairro_nome varchar(150) not null,
  logradouro_nome varchar(300),
  constraint uq_pais_uf_cidade_cep_zona_bairro_logradouro unique (pais_nome, uf_nome, cidade_nome, cep_numero, zona_nome, bairro_nome, logradouro_nome)
);

insert into logradouro values (nextval('sid_logradouro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','CENTRO','RUA BORBA GATO');
insert into logradouro values (nextval('sid_logradouro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','CENTRO','BARTOLOMEU BUENO');
insert into logradouro values (nextval('sid_logradouro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','CENTRO','RUA ANTÔNIO RAPOSA');
insert into logradouro values (nextval('sid_logradouro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','CENTRO','RUA NICOLAU BARRETO');
insert into logradouro values (nextval('sid_logradouro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','CENTRO','RUA MARTINS DE SÁ');
insert into logradouro values (nextval('sid_logradouro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','CENTRO','RUA FRANCISCO CHAVES');
insert into logradouro values (nextval('sid_logradouro'),(select current_date), (select current_time), true,'BRASIL','SP','OUROESTE','15685-000','URBANA','CENTRO','AV. DOS BANDEIRANTES');


--###############################################################################################################################################


CREATE SEQUENCE sid_ci;
CREATE TABLE ci -- Carteira de Identificação
(
  
  ci_de date, -- data de expedição
  
  
  ci_naturalidade_uf varchar(2) not null, -- estado onde o portador nasceu segundo o documento fornecido
  ci_naturalidade_cidade varchar(50) not null, -- cidade onde o portador nasceu segundo o documento fornecido
  ci_filiacao_mae varchar(50) not null, -- filiação da mãe
  ci_filiacao_pai varchar(50) not null, -- filiação do pai
  ci_origem_uf varchar (2), -- origem do estado (uf)
  ci_origem_cidade varchar(50), --origem da cidade
  ci_origem_obs varchar (50), -- outras informações (observações)
  ci_origem varchar (2), -- documento que deu origem ao registro geral (CN: Certidão de Nascimento ou CC: Certidão de Casamento)
  ci_origem_lv varchar (20), -- origem acervo
  ci_origem_fls varchar (20), -- origem folha
  ci_origem_n varchar (20), -- origem número
  --ci_cpf varchar (20), -- cpf (se houver)
  --ci_pis_pasep varchar(20), -- pis/pasep (se houver)
  CONSTRAINT pk_ci_uf_and_ci_ci PRIMARY KEY (ci_uf , ci_rg ),
  CONSTRAINT fk_ci_origem FOREIGN KEY (ci_origem)
      REFERENCES certidao (certidao_tipo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_ci_sexo FOREIGN KEY (ci_sexo)
      REFERENCES sexo (sexo_tipo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_ci_uf FOREIGN KEY (ci_uf)
      REFERENCES uf (uf_nome) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_ci_naturalidade_uf FOREIGN KEY (ci_naturalidade_uf)
      REFERENCES uf (uf_nome) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

insert into ci values (nextval('sid_ci'),(select current_date), (select current_time), true, 'SP','402265506','28/01/2002','DOUGLAS ESTANISLAU PEREIRA','17/10/1987','M','SP','FERNANDOPOLIS','MARIA ALCINEIDE ESTANISLAU PEREIRA','CLOVIS HENRIQUE PEREIRA','SP','FERNANDOPOLIS','FERNANDOPOLIS','CN','A69','122','016994','','');


--###############################################################################################################################################



create sequence sid_parentesco_tipo;
create table parentesco_tipo(
  parent_tipo_id bigint primary key,
  parent_tipo_data date not null,
  parent_tipo_hora time without time zone not null,
  parent_tipo_status boolean not null,
  parent_tipo varchar(30) unique,
  parent_tipo_descricao varchar(100)
);

insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'MÃE','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'PAI','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'FILHO(A)','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'TIO(A)','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'SOBRINHO(A)','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'IRMÃ(O)','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'AVÓ','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'NETO(A)','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'BISAVO','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'BISNETO(A)','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'PRIMO(A)','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'PRIMO(A) SEGUNDO(A)','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'PRIMO(A) TERCEIRO(A)','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'CUNHADO(A)','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'CONCUNHADO(A)','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'PADRASTRO','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'MADRASTA','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'ENTEADO(A)','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'GENRO','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'NORA','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'SOGRO(A)','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'TRISAVO','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'TRISNETO(A)','');
insert into parentesco_tipo values (nextval('sid_parentesco_tipo'),(select current_date), (select current_time), true,'NETEADO(A)','NEOLOGIA CRIADO PARA OS CASOS QUE O PAI/MAE POSSUEM PADRASTO OU MADRASTA');


--########################################################################################################################################################################


create sequence sid_parentesco;
create table parentesco(
  parentesco_id bigint primary key,
  parentesco_data date not null,
  parentesco_hora time without time zone not null,
  parentesco_status boolean not null,
  ci_uf varchar (2) NOT NULL,
  ci_rg varchar (20) NOT NULL,
  parentesco_tipo varchar(20) references parentesco_tipo (parent_tipo),
  parentesco_nome varchar(50),
  parentesco_vivo_morto boolean,
  parentesco_dn date, -- data de nascimento
  parentesco_df date, -- data de falecimento
  parentesco_obs varchar(200),
  CONSTRAINT fk_parentenco_ci_uf_and_ci_rg FOREIGN KEY (ci_uf, ci_rg)
      REFERENCES ci (ci_uf, ci_rg) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

insert into parentesco values (nextval('sid_parentesco'),(select current_date), (select current_time), true,'SP','402265506','MAE','MARIA ALCINEIDE ESTANISLAU PEREIRA',TRUE,'30/09/1968','01/01/1899','');


--########################################################################################################################################################################

-- TELEFONES

create sequence sid_telefone_ddd;
create table telefone_ddd(
  tel_ddd_id bigint NOT NULL primary key, 
  tel_ddd_data date NOT NULL, 
  tel_ddd_hora time without time zone NOT NULL, 
  tel_ddd_status boolean not null,
  tel_ddd_numero varchar(3) not null,
  tel_ddd_estado varchar(50),
  tel_ddd_cidade_regiao varchar(50)
);

insert into telefone_ddd values (nextval('sid_telefone_ddd'),(select current_date), (select current_time), true,'','','');
insert into telefone_ddd values (nextval('sid_telefone_ddd'),(select current_date), (select current_time), true,'17','SAO PAULO','SAO JOSE DO RIO PRETO/BARRETOS');


create sequence sid_telefone_operadora;
create table telefone_operadora(
  tel_operadora_id bigint NOT NULL primary key, 
  tel_operadora_data date NOT NULL, 
  tel_operadora_hora time without time zone NOT NULL, 
  tel_operadora_status boolean not null,
  tel_operadora varchar (20) unique
);

insert into telefone_operadora values (nextval('sid_telefone_operadora'),(select current_date), (select current_time), true,'');
insert into telefone_operadora values (nextval('sid_telefone_operadora'),(select current_date), (select current_time), true,'VIVO');
insert into telefone_operadora values (nextval('sid_telefone_operadora'),(select current_date), (select current_time), true,'TIM');
insert into telefone_operadora values (nextval('sid_telefone_operadora'),(select current_date), (select current_time), true,'OI');
insert into telefone_operadora values (nextval('sid_telefone_operadora'),(select current_date), (select current_time), true,'CLARO');


create sequence sid_telefone_tipo;
create table telefone_tipo(
  tel_tipo_id bigint NOT NULL primary key, 
  tel_tipo_data date NOT NULL, 
  tel_tipo_hora time without time zone NOT NULL, 
  tel_tipo_status boolean not null,
  tel_tipo varchar (20) unique
);

insert into telefone_tipo values (nextval('sid_telefone_tipo'),(select current_date), (select current_time), true,'');
insert into telefone_tipo values (nextval('sid_telefone_tipo'),(select current_date), (select current_time), true,'CELULAR');
insert into telefone_tipo values (nextval('sid_telefone_tipo'),(select current_date), (select current_time), true,'RESIDENCIAL');


create sequence sid_pessoa_telefone;
create table pessoa_telefone(
  tel_id bigint NOT NULL primary key, 
  tel_data date NOT NULL, 
  tel_hora time without time zone NOT NULL, 
  tel_status boolean not null,
  pessoa_ci_uf varchar (2) NOT NULL, 
  pessoa_ci_numero varchar (20) NOT NULL,
  tel_tipo varchar (20) references telefone_tipo (tel_tipo),
  tel_operadora varchar(20) references telefone_operadora (tel_operadora),
  tel_ddd_numero varchar (3) not null, -- references telefone_ddd (tel_ddd_numero)
  tel_numero varchar (15) not null,
  tel_ramal varchar (10),
  tel_obs varchar (50),
  CONSTRAINT fk_tel_ci_uf_and_ci_rg FOREIGN KEY (pessoa_ci_uf, pessoa_ci_numero)
      REFERENCES pessoa (pessoa_ci_uf, pessoa_ci_numero) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint uq_ci_uf_ci_rg_tel_ddd_tel_numero unique (pessoa_ci_uf, pessoa_ci_numero, tel_ddd_numero, tel_numero, tel_ramal)
);

insert into pessoa_telefone values (nextval('sid_pessoa_telefone'),(select current_date), (select current_time), true,'SP','402265506','CELULAR','VIVO','17','997848613','','');
insert into pessoa_telefone values (nextval('sid_pessoa_telefone'),(select current_date), (select current_time), true,'SP','402265506','CELULAR','VIVO','17','997013255','','');

--select tel_data, tel_tipo, tel_operadora, tel_ddd_numero, tel_numero, tel_ramal, pessoa_nome, tel_obs from pessoa_telefone pt, pessoa ps where (pt.pessoa_ci_uf, pt.pessoa_ci_numero) = (ps.pessoa_ci_uf, ps.pessoa_ci_numero) and pt. tel_status = true and ps.pessoa_status = true and ps.pessoa_nome like('%%') order by pt.pessoa_ci_uf, pt.pessoa_ci_numero, tel_id desc



create sequence sid_pessoa_endereco;
create table pessoa_endereco(
  pessoa_end_id bigint NOT NULL primary key, 
  pessoa_end_data date NOT NULL, 
  pessoa_end_hora time without time zone NOT NULL, 
  pessoa_end_status boolean not null,
  pessoa_ci_uf varchar (2) NOT NULL, 
  pessoa_ci_numero varchar (20) NOT NULL,
  pais_nome varchar(30) not null,
  uf_nome varchar (10) not null,
  cidade_nome varchar (50) not null,
  cep_numero varchar(30) not null,
  zona_nome varchar(30) not null,
  bairro_nome varchar(150) not null,
  logradouro_nome varchar(300) not null,
  pessoa_end_numero varchar(15) not null,
  pessoa_end_complemento varchar(300),
  pessoa_end_referencia varchar(300),
  CONSTRAINT fk_tel_ci_uf_and_ci_rg FOREIGN KEY (pessoa_ci_uf, pessoa_ci_numero)
      REFERENCES pessoa (pessoa_ci_uf, pessoa_ci_numero) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

insert into pessoa_endereco values (nextval('sid_pessoa_endereco'),(select current_date), (select current_time),true,'SP','402265506','BRASIL','SP','OUROESTE','15685-000','URBANA','CENTRO','BORBA GATO','1023','','');

--select * from pessoa_endereco where pessoa_end_status = true and pessoa_ci_uf = 'SP' and pessoa_ci_numero = '402265506' order by pessoa_end_id desc
--########################################################################################################################################################################

-- EMAIL'S

create sequence sid_email_tipo;
create table email_tipo(
  email_tipo_id bigint NOT NULL primary key, 
  email_tipo_data date NOT NULL, 
  email_tipo_hora time without time zone NOT NULL, 
  email_tipo_status boolean not null,
  email_tipo varchar (20) not null unique
);

insert into email_tipo values (nextval('sid_email_tipo'),(select current_date), (select current_time), true,'');
insert into email_tipo values (nextval('sid_email_tipo'),(select current_date), (select current_time), true,'PESSOAL');
insert into email_tipo values (nextval('sid_email_tipo'),(select current_date), (select current_time), true,'CASA');
insert into email_tipo values (nextval('sid_email_tipo'),(select current_date), (select current_time), true,'TRABALHO');


create sequence sid_email_provedor;
create table email_provedor(
  email_pro_id bigint NOT NULL primary key, 
  email_pro_data date NOT NULL, 
  email_pro_hora time without time zone NOT NULL, 
  email_pro_status boolean not null,
  email_pro_nome varchar (20) not null unique,
  email_pro_obs varchar (50)
);

insert into email_provedor values (nextval('sid_email_provedor'),(select current_date), (select current_time), true,'','');
insert into email_provedor values (nextval('sid_email_provedor'),(select current_date), (select current_time), true,'gmail.com','EMAIL DA GMAIL');
insert into email_provedor values (nextval('sid_email_provedor'),(select current_date), (select current_time), true,'hotmail.com','EMAIL DA HOTMAIL');
insert into email_provedor values (nextval('sid_email_provedor'),(select current_date), (select current_time), true,'hotmail.com.br','EMAIL DA HOTMAIL');
insert into email_provedor values (nextval('sid_email_provedor'),(select current_date), (select current_time), true,'yahoo.com','EMAIL DA YAHOO');
insert into email_provedor values (nextval('sid_email_provedor'),(select current_date), (select current_time), true,'yahoo.com.br','EMAIL DA YAHOO');



create sequence sid_pessoa_email;
create table pessoa_email(
  pessoa_email_id bigint NOT NULL primary key, 
  pessoa_email_data date NOT NULL, 
  pessoa_email_hora time without time zone NOT NULL, 
  pessoa_email_status boolean not null,
  ci_uf varchar (2) NOT NULL, 
  ci_rg varchar (20) NOT NULL,
  pessoa_email_nome varchar (20) not null,
  pessoa_email_pro_nome varchar (20) not null references email_provedor (email_pro_nome),
  pessoa_email_tipo varchar(20) references email_tipo (email_tipo),
  pessoa_email_obs varchar (50),
  CONSTRAINT fk_email_ci_uf_and_ci_rg FOREIGN KEY (ci_uf, ci_rg)
      REFERENCES pessoa (pessoa_ci_uf, pessoa_ci_numero) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint uq_ci_email_provedor unique (ci_uf, ci_rg, pessoa_email_nome, pessoa_email_pro_nome)
);

insert into pessoa_email values (nextval('sid_email'),(select current_date), (select current_time), true,'SP','402265506','douglairstan','gmail.com','PESSOAL','');


--########################################################################################################################################################################


create sequence sid_religiao;
create table religiao(
  religiao_id bigint NOT NULL primary key, 
  religiao_data date NOT NULL, 
  religiao_hora time without time zone NOT NULL, 
  religiao_status boolean not null,
  religiao_nome varchar (50) unique,
  religiao_descricao varchar
 );

insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'IGREJA CATOLICA ROMANA','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'IGREJA CATOLICA ORTODOXA','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'IGREJA NAO-CALCEDONIANAS','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'PROTESTANTISMO','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'ANABATISTAS','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'LUTERNANISMONOTA','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'ANGLICANISMO','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'CALVINISMO','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'IGREJA MENONITA','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'PRESBITERIANISMO','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'CONGREGACIONALISMO','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'BATISTAS','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'SOCIEDADE DOS AMIGOS','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'IGREJA MENONITA AMISH','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'IGREJA DE JESUS O DOS SANTOS DOS ULTIMOS DIAS','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'ADVENTISMO','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'IGREJA ADVENTISTA','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'ADELFIANOS','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'EXERCITO DE SALVACAO','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'CIENCIA A','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'TESTEMUNHAS DE JEOVA','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'IGREJA PRESBITERIANA INDEPENDENTE','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'PENTECOSTALISMO WILLIAM','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'IANISMO ROSACRUZ','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'CONGREGACAO A','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'ASSEMBLEIA DE DEUS','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'IGREJA DO EVANGELHO QUADRANGULAR','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'IGREJA UNIVERSAL DO REINO DE DEUS','');
insert into religiao values (nextval('sid_religiao'),(select current_date), (select current_time), true,'IGREJA MANA','');


--########################################################################################################################################################################

create sequence sid_cpf;
create table cpf(
  cpf_id bigint NOT NULL, -- identificação do cpf
  cpf_data date NOT NULL, -- data do cpf
  cpf_hora time without time zone NOT NULL, -- hora do cpf
  cpf_status boolean, -- status do cpf
  cpf_numero varchar(15) primary key, --numero do cpf
  ci_uf varchar (2) NOT NULL, -- unidade federativa do ci
  ci_numero varchar (20) NOT NULL,
  CONSTRAINT uq_cpf UNIQUE (cpf_id),
  CONSTRAINT fk_ci_uf_and_ci_rg FOREIGN KEY (ci_uf, ci_rg)
      REFERENCES ci (ci_uf, ci_rg) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

insert into cpf values (nextval('sid_cpf'),(select current_date), (select current_time), true,'34757565879','SP','402265506')

--########################################################################################################################################################################

--Biblioteca


drop sequence sid_acervo_relatar;
drop table acervo_relatar;

drop sequence sid_acervo_outros;
drop table acervo_outros;

drop sequence sid_outros;
drop table outros;

drop sequence sid_acervo_edicao;
drop table acervo_edicao;

drop sequence sid_acervo_class_liter;
drop table acervo_class_liter;

drop sequence sid_classificacao_literaria;
drop table classificacao_literaria;

drop sequence sid_acervo_tag;
drop table acervo_tag;

drop sequence sid_tag;
drop table tag;

drop sequence sid_acervo_autor;
drop table acervo_autor;

drop sequence sid_autor;
drop table autor;

drop sequence sid_acervo_tombo_empresa;
drop table acervo_tombo_empresa;

drop sequence sid_empresa;
drop table empresa;

drop sequence sid_acervo_genero;
drop table acervo_genero;

drop sequence sid_acervo;
drop table acervo;

drop sequence sid_acervo_editora;
drop table acervo_editora;

drop sequence sid_acervo_tipo;
drop table acervo_tipo;

drop sequence sid_acervo_colecao;
drop table acervo_colecao;

drop sequence sid_genero;
drop table genero;



create sequence sid_acervo_editora;
create table acervo_editora(
  acervo_editora_id bigint NOT NULL primary key,
  acervo_editora_data date NOT NULL,
  acervo_editora_hora time without time zone NOT NULL,
  acervo_editora_status boolean,
  acervo_editora_nome varchar(50) not null unique,
  acervo_editora_obs varchar
);

insert into acervo_editora values (nextval('sid_acervo_editora'),(select current_date), (select current_time), true,'','');
insert into acervo_editora values (nextval('sid_acervo_editora'),(select current_date), (select current_time), true,'MODERNA','');
insert into acervo_editora values (nextval('sid_acervo_editora'),(select current_date), (select current_time), true,'JOSÉ OLYMPIO','');



create sequence sid_acervo_colecao;
create table acervo_colecao(
  acervo_colecao_id bigint NOT NULL primary key,
  acervo_colecao_data date NOT NULL,
  acervo_colecao_hora time without time zone NOT NULL,
  acervo_colecao_status boolean,
  acervo_colecao_nome varchar(50) not null unique,
  acervo_colecao_obs varchar
);

insert into acervo_colecao values (nextval('sid_acervo_colecao'),(select current_date), (select current_time), true,'','');
insert into acervo_colecao values (nextval('sid_acervo_colecao'),(select current_date), (select current_time), true,'VEREDAS','');



create sequence sid_acervo_tipo;
create table acervo_tipo(
  acervo_tipo_id bigint NOT NULL primary key,
  acervo_tipo_data date NOT NULL,
  acervo_tipo_hora time without time zone NOT NULL,
  acervo_tipo_status boolean,
  acervo_tipo_nome varchar(50) not null unique,
  acervo_tipo_obs varchar
);

insert into acervo_tipo values (nextval('sid_acervo_tipo'),(select current_date), (select current_time), true,'LIVRO','');
insert into acervo_tipo values (nextval('sid_acervo_tipo'),(select current_date), (select current_time), true,'REVISTA','');
insert into acervo_tipo values (nextval('sid_acervo_tipo'),(select current_date), (select current_time), true,'DICIONÁRIO','');



create sequence sid_acervo;
create table acervo(
  acervo_id bigint NOT NULL,
  acervo_data date NOT NULL,
  acervo_hora time without time zone NOT NULL,
  acervo_status boolean,
  acervo_isbn varchar(20) not null primary key,
  acervo_nome varchar(100) not null,
  acervo_subtitulo varchar (100),
  acervo_colecao varchar(50) references acervo_colecao (acervo_colecao_nome),
  acervo_editora varchar(50) references acervo_editora (acervo_editora_nome),
  acervo_tipo varchar(20) references acervo_tipo (acervo_tipo_nome), -- acervo, revista e etc...
  acervo_paginas varchar(5), -- número de páginas
  acervo_volume varchar(5),
  acervo_linguagem varchar(20),
  acervo_resumo varchar,
  acervo_obs varchar
);

insert into acervo values (nextval('sid_acervo'),(select current_date), (select current_time), true,'8516006301','MUITO ALÉM DA IMAGINAÇÃO','','VEREDAS','MODERNA','LIVRO','53','','PORTUGUÊS','','');
insert into acervo values (nextval('sid_acervo'),(select current_date), (select current_time), true,'9788503005197','O CERTO É O CONTRÁRIO','','','MODERNA','LIVRO','43','','PORTUGUÊS','','');


-- Empresa
create sequence sid_empresa;
create table empresa(
  empresa_id bigint NOT NULL,
  empresa_data date NOT NULL,
  empresa_hora time without time zone NOT NULL,
  empresa_status boolean,
  empresa_cnpj varchar(20) not null primary key,
  empresa_nome varchar(50) not null
);

insert into empresa values (nextval('sid_empresa'),(select current_date), (select current_time), true,'01611213000112','EMEF OUROESTE');



-- Empresa Salas
create sequence sid_empresa_sala;
create table empresa_sala(
  empresa_sala_id bigint NOT NULL,
  empresa_sala_data date NOT NULL,
  empresa_sala_hora time without time zone NOT NULL,
  empresa_sala_status boolean,
  empresa_cnpj varchar(20) not null references empresa (empresa_cnpj),
  empresa_sala_numero varchar(5) not null primary key,
  empresa_sala_andar varchar(20),
  empresa_sala_dim_l numeric(4,2),
  empresa_sala_dim_c numeric(4,2),
  empresa_sala_dim_a numeric(4,2),
  empresa_sala_descricao varchar(100),
  constraint uq_empresa_cnpj_sala_numero unique (empresa_cnpj, empresa_sala_numero)
);

insert into empresa_sala values (nextval('sid_empresa_sala'),(select current_date), (select current_time), true,'01611213000112','1','TERREO',7.5,8.35,2.95,'SALA DE INFORMÁTICA');

--select empresa_sala_numero, empresa_sala_andar, empresa_sala_dim_l, empresa_sala_dim_c, empresa_sala_dim_a,(empresa_sala_dim_l*empresa_sala_dim_c) as m2,(empresa_sala_dim_l*empresa_sala_dim_c*empresa_sala_dim_a) as m3, empresa_sala_descricao from empresa_sala where empresa_sala_status = true and empresa_cnpj = '01611213000112'



create sequence sid_acervo_tombo_empresa;
create table acervo_tombo_empresa(
  acervo_tombo_empresa_id bigint NOT NULL primary key,
  acervo_tombo_empresa_data date NOT NULL,
  acervo_tombo_empresa_hora time without time zone NOT NULL,
  acervo_tombo_empresa_status boolean,
  acervo_isbn varchar(20) not null references acervo (acervo_isbn),
  empresa_cnpj varchar(20) not null references empresa (empresa_cnpj),
  acervo_tombo_empresa_numero varchar(20),-- unique, --tombo da empresa
  acervo_tombo_empresa_quantidade integer,
  acervo_tombo_empresa_obs varchar,
  CONSTRAINT uq_acervo_isbn_empresa_cnpj_tombo UNIQUE (acervo_isbn, empresa_cnpj, acervo_tombo_empresa_numero)
);

insert into acervo_tombo_empresa values (nextval('sid_acervo_tombo_empresa'),(select current_date), (select current_time), true,'8516006301','01611213000112','7075B',1,'');
insert into acervo_tombo_empresa values (nextval('sid_acervo_tombo_empresa'),(select current_date), (select current_time), true,'9788503005197','01611213000112','0423',1,'');



create sequence sid_autor;
create table autor(
  autor_id bigint NOT NULL primary key,
  autor_data date NOT NULL,
  autor_hora time without time zone NOT NULL,
  autor_status boolean,
  autor_nome varchar(100) not null unique,
  autor_sobre varchar
  --Nacionalidade	Brasil Brasileiro
  --Data de nascimento	18 de abril de 1882
  --Local de nascimento	Taubaté, Império do Brasil
  --Data de falecimento	4 de julho de 1948 (66 anos)
  --Local de falecimento	São Paulo, Brasil
  --Ocupação	escritor
  --URL     WIKIPEDIA
);

insert into autor values (nextval('sid_autor'),(select current_date), (select current_time), true,'','');
insert into autor values (nextval('sid_autor'),(select current_date), (select current_time), true,'MARIA DE REGINO','');
insert into autor values (nextval('sid_autor'),(select current_date), (select current_time), true,'IVAN JAF','');



create sequence sid_acervo_autor;
create table acervo_autor(
  acervo_autor_id bigint NOT NULL primary key,
  acervo_autor_data date NOT NULL,
  acervo_autor_hora time without time zone NOT NULL,
  acervo_autor_status boolean,
  acervo_isbn varchar(20) not null references acervo (acervo_isbn),
  autor_nome varchar(100) not null references autor (autor_nome),
  CONSTRAINT uq_acervo_isbn_autor_nome UNIQUE (acervo_isbn, autor_nome)
);

insert into acervo_autor values (nextval('sid_acervo_autor'),(select current_date), (select current_time), true,'8516006301','MARIA DE REGINO');
insert into acervo_autor values (nextval('sid_acervo_autor'),(select current_date), (select current_time), true,'9788503005197','IVAN JAF');



create sequence sid_genero;
create table genero(
  genero_id bigint NOT NULL primary key,
  genero_data date NOT NULL,
  genero_hora time without time zone NOT NULL,
  genero_status boolean,
  genero_nome varchar(100) not null unique,
  genero_obs varchar
);

insert into genero values (nextval('sid_genero'),(select current_date), (select current_time), true,'','');
insert into genero values (nextval('sid_genero'),(select current_date), (select current_time), true,'ROMANCE','');



create sequence sid_acervo_genero;
create table acervo_genero(
  acervo_genero_id bigint NOT NULL primary key,
  acervo_genero_data date NOT NULL,
  acervo_genero_hora time without time zone NOT NULL,
  acervo_genero_status boolean,
  acervo_isbn varchar(20) not null references acervo (acervo_isbn),
  genero_nome varchar(100) not null references genero (genero_nome),
  CONSTRAINT uq_acervo_isbn_genero_nome UNIQUE (acervo_isbn, genero_nome)
);

insert into acervo_genero values (nextval('sid_acervo_genero'),(select current_date), (select current_time), true,'8516006301','ROMANCE');



create sequence sid_tag;
create table tag(
  tag_id bigint NOT NULL primary key,
  tag_data date NOT NULL,
  tag_hora time without time zone NOT NULL,
  tag_status boolean,
  tag_nome varchar(100) not null unique,
  tag_obs varchar
);

insert into tag values (nextval('sid_tag'),(select current_date), (select current_time), true,'','');
insert into tag values (nextval('sid_tag'),(select current_date), (select current_time), true,'INFANTIL','');
insert into tag values (nextval('sid_tag'),(select current_date), (select current_time), true,'AMOR','');
insert into tag values (nextval('sid_tag'),(select current_date), (select current_time), true,'ECOLOGIA','');
insert into tag values (nextval('sid_tag'),(select current_date), (select current_time), true,'BICHOS','');
insert into tag values (nextval('sid_tag'),(select current_date), (select current_time), true,'ANIMAIS','');
insert into tag values (nextval('sid_tag'),(select current_date), (select current_time), true,'FLOR','');
insert into tag values (nextval('sid_tag'),(select current_date), (select current_time), true,'BIOMA','');



create sequence sid_acervo_tag;
create table acervo_tag(
  acervo_tag_id bigint NOT NULL primary key,
  acervo_tag_data date NOT NULL,
  acervo_tag_hora time without time zone NOT NULL,
  acervo_tag_status boolean,
  acervo_isbn varchar(20) not null references acervo (acervo_isbn),
  tag_nome varchar(100) not null references tag (tag_nome),
  CONSTRAINT uq_acervo_isbn_tag_nome UNIQUE (acervo_isbn, tag_nome)
);

insert into acervo_tag values (nextval('sid_acervo_tag'),(select current_date), (select current_time), true,'8516006301','AMOR');



create sequence sid_classificacao_literaria;
create table classificacao_literaria(
  classificacao_literaria_id bigint NOT NULL primary key,
  classificacao_literaria_data date NOT NULL,
  classificacao_literaria_hora time without time zone NOT NULL,
  classificacao_literaria_status boolean,
  classificacao_literaria_nome varchar(100) not null unique,
  classificacao_literaria_obs varchar
);

insert into classificacao_literaria values (nextval('sid_classificacao_literaria'),(select current_date), (select current_time), true,'','');
insert into classificacao_literaria values (nextval('sid_classificacao_literaria'),(select current_date), (select current_time), true,'LITERATURA INFANTO-JUVENIL','');
insert into classificacao_literaria values (nextval('sid_classificacao_literaria'),(select current_date), (select current_time), true,'LITERATURA JUVENIL','');



create sequence sid_acervo_class_liter;
create table acervo_class_liter(
  acervo_class_liter_id bigint NOT NULL primary key,
  acervo_class_liter_data date NOT NULL,
  acervo_class_liter_hora time without time zone NOT NULL,
  acervo_class_liter_status boolean,
  acervo_isbn varchar(20) not null references acervo (acervo_isbn),
  classificacao_literaria_nome varchar(100) not null references classificacao_literaria (classificacao_literaria_nome),
  CONSTRAINT uq_ UNIQUE (acervo_isbn, classificacao_literaria_nome)
);

insert into acervo_class_liter values (nextval('sid_acervo_class_liter'),(select current_date), (select current_time), true,'8516006301','LITERATURA INFANTO-JUVENIL');
insert into acervo_class_liter values (nextval('sid_acervo_class_liter'),(select current_date), (select current_time), true,'8516006301','LITERATURA JUVENIL');
insert into acervo_class_liter values (nextval('sid_acervo_class_liter'),(select current_date), (select current_time), true,'9788503005197','LITERATURA INFANTO-JUVENIL');



create sequence sid_acervo_edicao;
create table acervo_edicao(
  acervo_edicao_id bigint NOT NULL primary key,
  acervo_edicao_data date NOT NULL,
  acervo_edicao_hora time without time zone NOT NULL,
  acervo_edicao_status boolean,
  acervo_isbn varchar (20) not null references acervo (acervo_isbn),
  acervo_edicao_numero varchar(5) not null,
  acervo_edicao_cidade varchar(50),
  acervo_edicao_ano varchar(5),
  CONSTRAINT uq_acervo_isbn_acervo_edicao_numero_cidade_ano UNIQUE (acervo_isbn, acervo_edicao_numero, acervo_edicao_cidade, acervo_edicao_ano)
);

insert into acervo_edicao values (nextval('sid_acervo_edicao'),(select current_date), (select current_time), true,'9788503005197','9','RIO DE JANEIRO/RJ','2005');
insert into acervo_edicao values (nextval('sid_acervo_edicao'),(select current_date), (select current_time), true,'8516006301','7','SÃO PAULO/SP','1992');



create sequence sid_outros;
create table outros(
  outros_id bigint NOT NULL primary key,
  outros_data date NOT NULL,
  outros_hora time without time zone NOT NULL,
  outros_status boolean,
  outros_tipo varchar(20) not null,
  outros_nome varchar(100) not null,
  outros_obs varchar,
  CONSTRAINT uq_outros_tipo_nome UNIQUE (outros_tipo, outros_nome)
);

insert into outros values (nextval('sid_outros'),(select current_date), (select current_time), true,'','','');
insert into outros values (nextval('sid_outros'),(select current_date), (select current_time), true,'LIVRO','COORDENAÇÃO EDITORAL:','');
insert into outros values (nextval('sid_outros'),(select current_date), (select current_time), true,'LIVRO','PREPARAÇÃO DE ORIGINAIS:','');
insert into outros values (nextval('sid_outros'),(select current_date), (select current_time), true,'LIVRO','REVISÃO:','');
insert into outros values (nextval('sid_outros'),(select current_date), (select current_time), true,'LIVRO','ARTES:','');
insert into outros values (nextval('sid_outros'),(select current_date), (select current_time), true,'LIVRO','CAPA E ILUSTRAÇÃOES:','');



create sequence sid_acervo_outros;
create table acervo_outros(
  acervo_outros_id bigint NOT NULL primary key,
  acervo_outros_data date NOT NULL,
  acervo_outros_hora time without time zone NOT NULL,
  acervo_outros_status boolean,
  acervo_isbn varchar(20) not null references acervo (acervo_isbn),
  outros_nome varchar(100), --references outros (outros_nome),
  acervo_outros_nome2 varchar(100)
);

insert into acervo_outros values (nextval('sid_acervo_outros'),(select current_date), (select current_time), true,'8516006301','CAPA E ILUSTRAÇÃOES:','ROGÉRIO BORGES');
insert into acervo_outros values (nextval('sid_acervo_outros'),(select current_date), (select current_time), true,'9788503005197','CAPA E ILUSTRAÇÃOES:','IKE VILELA');



create sequence sid_acervo_relatar;
create table acervo_relatar(
  acervo_relatar_id bigint NOT NULL primary key,
  acervo_relatar_data date NOT NULL,
  acervo_relatar_hora time without time zone NOT NULL,
  acervo_relatar_status boolean,
  empresa_cnpj varchar(20) not null references empresa (empresa_cnpj),
  acervo_tombo_empresa_numero varchar(20) not null, --references acervo_tombo_empresa
  --acervo_nome varchar(100) not null,
  pessoa_ci_uf varchar(5) not null, --references pessoa
  pessoa_ci_numero varchar(20) not null, --references pessoa
  --pessoa_nome varchar(300) not null, --references pessoa
  acervo_relatar_data_saida date
  );

--insert into acervo_relatar values (nextval('sid_acervo_relatar'),(select current_date), (select current_time), true,'01611213000112','7075B','SP','402265506',null);

--select a.acervo_nome, a.acervo_colecao, a.acervo_editora, a.acervo_tipo, a.acervo_paginas, a.acervo_volume, a.acervo_linguagem, a.acervo_resumo, ate.acervo_tombo_empresa_numero, ate.acervo_tombo_empresa_quantidade from acervo a, acervo_tombo_empresa ate where a.acervo_isbn = ate.acervo_isbn and ate.empresa_cnpj = '01611213000112' and a.acervo_isbn = '1111111111111'

--select ar.acervo_relatar_id, ar.acervo_relatar_data, ar.acervo_relatar_data_saida, ar.acervo_relatar_data_saida - ar.acervo_relatar_data as dias, ar.acervo_tombo_empresa_numero, a.acervo_nome, ar.pessoa_ci_uf, ar.pessoa_ci_numero, ps.pessoa_nome from acervo_relatar ar, pessoa ps, acervo_tombo_empresa ate, acervo a where (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (ar.pessoa_ci_uf, ar.pessoa_ci_numero) and ate.acervo_tombo_empresa_numero = ar.acervo_tombo_empresa_numero and ate.acervo_isbn = a.acervo_isbn and ate.empresa_cnpj = '' and ar.acervo_relatar_status = true and ps.pessoa_nome like('%%') order by ar.acervo_relatar_id desc

--select ar.acervo_relatar_id, ar.acervo_relatar_data, ar.acervo_relatar_data_saida, ar.acervo_relatar_data_saida - ar.acervo_relatar_data as dias, ar.acervo_tombo_empresa_numero, a.acervo_nome, ar.pessoa_ci_uf, ar.pessoa_ci_numero, ps.pessoa_nome from acervo_relatar ar, pessoa ps, acervo_tombo_empresa ate, acervo a where (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (ar.pessoa_ci_uf, ar.pessoa_ci_numero) and ate.acervo_tombo_empresa_numero = ar.acervo_tombo_empresa_numero and ate.acervo_isbn = a.acervo_isbn and ate.empresa_cnpj = '' and ar.acervo_relatar_status = true and a.acervo_nome like('%%') order by ar.acervo_relatar_id desc

--########################################################################################################################################################################


create sequence sid_historico;
create table historico(
  historico_id bigint NOT NULL primary key,
  historico_data date NOT NULL,
  historico_hora time without time zone NOT NULL,
  historico_status boolean,
  historico_empresa varchar(20) not null references empresa(empresa_cnpj),
  historico_tipo varchar(20) not null,
  historico_descricao varchar not null
);

insert into historico values (nextval('sid_historico'),(select current_date), (select current_time),true,'01611213000112','','');

--###############################################################################################################################################
create sequence sid_cr;
create table cr(
  cr_id bigint NOT NULL primary key,
  cr_data date NOT NULL,
  cr_hora time without time zone NOT NULL,
  cr_status boolean not null,
  cr_tipo varchar(10) not null unique,
  cr_descricao varchar
);

insert into cr values (nextval('sid_cr'), (select current_date), (select current_time),true, 'CRM-SP', '');


create sequence sid_medico;
create table medico(
  medico_id bigint NOT NULL primary key,
  medico_data date NOT NULL,
  medico_hora time without time zone NOT NULL,
  medico_status boolean,
  medico_tipo varchar(10) not null references cr(cr_tipo),
  medico_codigo varchar(10) not null unique,
  medico_sexo varchar(5) not null references sexo(sexo_tipo),
  --medico_especialista varchar(30) not null references medico_especialista(medico_especialista_tipo),
  medico_nome varchar(100) not null,
  constraint uq_medico unique (medico_tipo, medico_codigo)
);

insert into medico values (nextval('sid_medico'),(select current_date), (select current_time),true,'CRM-SP','147378','F','LUCILENE S. ONIBENI BETIOL');
insert into medico values (nextval('sid_medico'),(select current_date), (select current_time),true,'CRM-SP','95934','F','TELMA TONET');
insert into medico values (nextval('sid_medico'),(select current_date), (select current_time),true,'CRM-SP','28313','F','MARCO AURELIO VAN ERVEN');


create sequence sid_medico_especialista;
create table medico_especialista(
  medico_especialista_id bigint NOT NULL primary key,
  medico_especialista_data date NOT NULL,
  medico_especialista_hora time without time zone NOT NULL,
  medico_especialista_status boolean not null,
  medico_tipo varchar(10) not null,
  medico_codigo varchar(10) not null,
  medico_especialista_nome varchar(40) not null,
  medico_especialista_descricao varchar,
  constraint fk_medico_especialista FOREIGN KEY (medico_tipo, medico_codigo) REFERENCES medico (medico_tipo, medico_codigo),
  constraint uq_medico_especialista unique (medico_tipo, medico_codigo, medico_especialista_nome)
);

insert into medico_especialista values (nextval('sid_medico_especialista'), (select current_date), (select current_time),true, 'CRM-SP','147378','PEDIATRA','');
insert into medico_especialista values (nextval('sid_medico_especialista'), (select current_date), (select current_time),true, 'CRM-SP','95934','PEDIATRA','');
insert into medico_especialista values (nextval('sid_medico_especialista'), (select current_date), (select current_time),true, 'CRM-SP','28313','PSIQUIATRA','');

--###############################################################################################################################################

create sequence sid_certificadora;
create table certificadora(
  certificadora_id bigint NOT NULL primary key,
  certificadora_data date NOT NULL,
  certificadora_hora time without time zone NOT NULL,
  certificadora_status boolean not null,
  certificadora_nome varchar(50) not null unique,
  certificadora_obs varchar
  );

  insert into certificadora values (nextval('sid_certificadora'), (select current_date), (select current_time),true, 'UERGS - UNIVERSIDADE ESTADUAL DO RIO GRANDE DO SUL','');
  insert into certificadora values (nextval('sid_certificadora'), (select current_date), (select current_time),true, 'FEF - FACULDADE EDUCACIONAL DE FERNANDOPOLIS','');

create sequence sid_curso;
create table curso(
  curso_id bigint NOT NULL primary key,
  curso_data date NOT NULL,
  curso_hora time without time zone NOT NULL,
  curso_status boolean not null,
  curso_nome varchar(50) not null unique,
  curso_subnome varchar(50),
  curso_obs varchar
  );

  insert into curso values (nextval('sid_curso'), (select current_date), (select current_time),true, 'SISTEMAS DE INFORMAÇÃO','','');
  insert into curso values (nextval('sid_curso'), (select current_date), (select current_time),true, 'CIÊNCIAS BIOLÓGICAS','','');

--###############################################################################################################################################

-- Série/Turma



-- Ano Letivo
create sequence sid_ano_letivo;
create table ano_letivo(
  ano_letivo_id bigint NOT NULL primary key,
  ano_letivo_data date NOT NULL,
  ano_letivo_hora time without time zone NOT NULL,
  ano_letivo_status boolean,
  ano_letivo_ano int not null unique
);

insert into ano_letivo values (nextval('sid_ano_letivo'),(select current_date), (select current_time),true,2014);



-- Ensino
create sequence sid_ensino;
create table ensino(
  ensino_id bigint NOT NULL primary key,
  ensino_data date NOT NULL,
  ensino_hora time without time zone not null,
  ensino_status boolean,
  ensino_nome varchar(50) not null unique,
  ensino_descricao varchar(50)
);

insert into ensino values (nextval('sid_ensino'),(select current_date), (select current_time),true,'INFANTIL','');
insert into ensino values (nextval('sid_ensino'),(select current_date), (select current_time),true,'FUNDAMENTAL I','');
insert into ensino values (nextval('sid_ensino'),(select current_date), (select current_time),true,'FUNDAMENTAL II','');
insert into ensino values (nextval('sid_ensino'),(select current_date), (select current_time),true,'MÉDIO','');



-- Ensino Série
create sequence sid_ensino_serie;
create table ensino_serie(
  ensino_serie_id bigint NOT NULL primary key,
  ensino_serie_data date NOT NULL,
  ensino_serie_hora time without time zone not null,
  ensino_serie_status boolean,
  ensino_nome varchar(50) not null references ensino(ensino_nome),
  ensino_serie_nome varchar(50),
  constraint uq_ensino_serie unique (ensino_nome, ensino_serie_nome)
);

insert into ensino_serie values (nextval('sid_ensino_serie'),(select current_date), (select current_time),true,'FUNDAMENTAL I','1A');
insert into ensino_serie values (nextval('sid_ensino_serie'),(select current_date), (select current_time),true,'FUNDAMENTAL I','2A');
insert into ensino_serie values (nextval('sid_ensino_serie'),(select current_date), (select current_time),true,'FUNDAMENTAL I','3A');
insert into ensino_serie values (nextval('sid_ensino_serie'),(select current_date), (select current_time),true,'FUNDAMENTAL I','4A');
insert into ensino_serie values (nextval('sid_ensino_serie'),(select current_date), (select current_time),true,'FUNDAMENTAL I','5A');



-- Periodo
create sequence sid_periodo;
create table periodo(
  periodo_id bigint NOT NULL primary key,
  periodo_data date NOT NULL,
  periodo_hora time without time zone NOT NULL,
  periodo_status boolean,
  periodo_nome varchar(50) not null unique,
  periodo_descricao varchar(50)
);

insert into periodo values (nextval('sid_periodo'),(select current_date), (select current_time),true,'MATUTINO','PERÍODO DA MANHÃ');
insert into periodo values (nextval('sid_periodo'),(select current_date), (select current_time),true,'VESPERTINO','PERÍODO DA TARDE');
insert into periodo values (nextval('sid_periodo'),(select current_date), (select current_time),true,'NOTURNO','PERÍODO DA NOITE');


-- Turma
create sequence sid_turma;
create table turma(
  turma_id bigint NOT NULL primary key,
  turma_data date NOT NULL,
  turma_hora time without time zone not null,
  turma_status boolean,
  empresa_cnpj varchar(20) not null references empresa (empresa_cnpj),
  ano_letivo_ano int not null references ano_letivo (ano_letivo_ano),
  periodo_nome varchar(50) not null references periodo (periodo_nome),
  ensino_nome varchar(50) not null references ensino (ensino_nome),
  ensino_serie_nome varchar(50) not null,-- references ensino_serie (ensino_serie_nome),
  turma_nome varchar(50) not null,
  constraint uq_turma_cnpj_ano_periodo_ensino_serie unique (empresa_cnpj, ano_letivo_ano, periodo_nome, ensino_nome, ensino_serie_nome, turma_nome)
);
  

insert into turma values (nextval('sid_turma'),(select current_date), (select current_time),true,'01611213000112',2014,'MATUTINO','FUNDAMENTAL I','1A','A');
insert into turma values (nextval('sid_turma'),(select current_date), (select current_time),true,'01611213000112',2014,'MATUTINO','FUNDAMENTAL I','1A','B');

--select turma_nome from turma where turma_status = true and empresa_cnpj = '01611213000112' and ano_letivo_ano = (select max(ano_letivo_ano) from ano_letivo) and periodo_nome = 'MATUTINO' and ensino_nome = 'FUNDAMENTAL I' and ensino_serie_nome = '1A' order by turma_nome


-- Classe
create sequence sid_classe;
create table classe(
  classe_id bigint NOT NULL,
  classe_data date NOT NULL,
  classe_hora time without time zone NOT NULL,
  classe_status boolean,
  classe_numero varchar(15) not null primary key, --1111111
  empresa_cnpj varchar(20) not null references empresa (empresa_cnpj), --01611213000112
  ensino_nome varchar(50) not null, --references tipo_ensino(tipo_ensino_nome), --fundamental I
  ensino_serie varchar(50) not null, -- 1A
  turma_nome varchar(50) not null, --references tipo_turma (tipo_turma_nome),-- A
  periodo_nome varchar(50) not null, --references tipo_turno (tipo_turno_nome), --manhã
  ano_letivo_ano int not null references ano_letivo (ano_letivo_ano), --2013
  empresa_sala_numero varchar(5) not null, --references empresa_sala (empresa_sala_numero),
  classe_hinicial time,
  classe_hfinal time,
  classe_obs varchar(200),
  constraint ck_horario_classe check (classe_hinicial < classe_hfinal)
);

insert into classe values (nextval('sid_classe'),(select current_date), (select current_time),true,'1111111111','01611213000112','FUNDAMENTAL I','1A','A','MATUTINO',2014,'1','07:10','11:40','OBS');



--drop sequence sid_aluno_classe;
--drop table aluno_classe;

--Aluno Classe
create sequence sid_aluno_classe;
create table aluno_classe(
  aluno_classe_id bigint NOT NULL primary key,
  aluno_classe_data date NOT NULL,
  aluno_classe_hora time without time zone NOT NULL,
  aluno_classe_status boolean,
  classe_numero varchar(15) references classe (classe_numero),
  empresa_cnpj varchar(20) not null references empresa (empresa_cnpj), --01611213000112
  pessoa_ci_uf varchar(5) not null,
  pessoa_ci_numero varchar(20) not null,
  aluno_classe_nchamada int not null,
  aluno_classe_tranf varchar(30),--tranferência (escola ou cidade)
  aluno_classe_rem varchar(30),--remanejado (de uma sala para outra)
  aluno_classe_sit varchar(30),--situação
  aluno_classe_def varchar(30),--deferido
  aluno_classe_obs varchar(300),--observação
  constraint fk_serie_turma_pessoa_ci_uf_ci FOREIGN KEY (pessoa_ci_uf, pessoa_ci_numero) REFERENCES pessoa (pessoa_ci_uf, pessoa_ci_numero),
  constraint uq_classe_numero_nchamda unique (classe_numero, aluno_classe_nchamada)
);

insert into aluno_classe values (nextval('sid_aluno_classe'),(select current_date), (select current_time),true,'1111111111','01611213000112','SP','402265506',1,'','','','','');

--Disciplina
create sequence sid_disciplina;
create table disciplina(
  disciplina_id bigint NOT NULL primary key,
  disciplina_data date NOT NULL,
  disciplina_hora time without time zone NOT NULL,
  disciplina_status boolean,
  disciplina_nome varchar(50) not null unique,
  disciplina_descricao varchar(200)
);

insert into disciplina values (nextval('sid_disciplina'),(select current_date), (select current_time),true,'MATEMÁTICA','');

--###############################################################################################################################################

-- Empresa Relatos
create sequence sid_empresa_relatos;
create table empresa_relatos(
  empresa_relatos_id bigint NOT NULL primary key,
  empresa_relatos_data date NOT NULL,
  empresa_relatos_hora time without time zone NOT NULL,
  empresa_relatos_status boolean,
  empresa_cnpj varchar(20) not null references empresa (empresa_cnpj),
  empresa_relatos_tipo1 varchar(50) not null,
  empresa_relatos_tipo2 varchar(50) not null,
  empresa_relatos_descricao1 varchar not null,
  empresa_relatos_descricao2 varchar not null,
  empresa_relatos_descricao3 varchar not null,
  empresa_relatos_descricao4 varchar not null,
  empresa_relatos_dataf date not null
  );


--insert into empresa_relatos values (nextval('sid_empresa_relatos'),(select current_date), (select current_time),true,'01611213000112','OCORRÊNCIA','DO ALUNO','O ALUNO...','','','',);
--insert into empresa_relatos values (nextval('sid_empresa_relatos'),(select current_date), (select current_time),true,'01611213000112','ENCAMINHAMENTO','FONOAUDIÓLOGO','O ALUNO...','','','',);
--insert into empresa_relatos values (nextval('sid_empresa_relatos'),(select current_date), (select current_time),true,'01611213000112','ENCAMINHAMENTO','PISICÓLOGO','O ALUNO...','','','',);
--insert into empresa_relatos values (nextval('sid_empresa_relatos'),(select current_date), (select current_time),true,'01611213000112','ENCAMINHAMENTO','AEE','O ALUNO...','','','',);
--insert into empresa_relatos values (nextval('sid_empresa_relatos'),(select current_date), (select current_time),true,'01611213000112','RELATÓRIO','INDIVIDUAL DO ALUNO','O ALUNO...','','','',);
--insert into empresa_relatos values (nextval('sid_empresa_relatos'),(select current_date), (select current_time),true,'01611213000112','RELATÓRIO','DE CLASSE','O ALUNO...','','','',);


-- Empresa Relatos Pessoas
create sequence sid_empresa_relatos_pessoas;
create table empresa_relatos_pessoas(
  empresa_relatos_pessoas_id bigint NOT NULL primary key,
  empresa_relatos_pessoas_data date NOT NULL,
  empresa_relatos_pessoas_hora time without time zone NOT NULL,
  empresa_relatos_pessoas_status boolean,
  empresa_cnpj varchar(20) not null references empresa (empresa_cnpj),
  empresa_relatos_id bigint NOT NULL references empresa_relatos (empresa_relatos_id),
  pessoa_ci_uf varchar(5) not null,
  pessoa_ci_numero varchar(20) not null,
  pessoa_tipo varchar(30),
  constraint fk_empresa_relatos_pessoas FOREIGN KEY (pessoa_ci_uf, pessoa_ci_numero) REFERENCES pessoa (pessoa_ci_uf, pessoa_ci_numero)
);


insert into empresa_relatos_pessoas values (nextval('sid_empresa_relatos_pessoas'),(select current_date), (select current_time),true,'01611213000112',1,'SP','402265506',(select cargo_nome from registro_pessoa_empresa where empresa_cnpj = '01611213000112' and rpe_status = true and pessoa_ci_uf = 'SP' and pessoa_ci_numero = '402265506'));


--select ar.aluno_relatorio_id, ar.aluno_relatorio_data, ps.pessoa_nome, ep.empresa_nome  from aluno_relatorio ar, pessoa ps, empresa ep where (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (ar.pessoa_ci_uf, ar.pessoa_ci_numero) and ar.aluno_relatorio_status = true and ar.aluno_uf = 'SP' and ar.aluno_ra = '1037180380' order by 1 desc

--select ar.aluno_relatorio_id, ar.aluno_relatorio_data, ps.pessoa_ci_uf, ps.pessoa_ci_numero, ps.pessoa_nome, ep.empresa_nome  from aluno_relatorio ar, pessoa ps, empresa ep where (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (ar.aluno_uf, ar.aluno_ra) and ar.aluno_relatorio_status = true and ar.pessoa_ci_uf = 'SP' and ar.pessoa_ci_numero = '402265506' order by 1 desc

-- VISUALIZACAO DO DOCENTE (VISTOS E NAO VISTOS)
--select ar.empresa_relatos_id as id, ar.empresa_relatos_data as data, ps.pessoa_ci_uf, ps.pessoa_ci_numero, ps.pessoa_nome FROM  empresa_relatos ar, pessoa ps, empresa ep, empresa_relatos_pessoas erp WHERE (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (erp.pessoa_ci_uf, erp.pessoa_ci_numero) and erp.pessoa_tipo = 'ALUNO(A)' and erp.empresa_relatos_id = ar.empresa_relatos_id and ep.empresa_cnpj = ar.empresa_cnpj and NOT EXISTS (SELECT * FROM docente_visualizacao dv WHERE dv.empresa_relatos_id = ar.empresa_relatos_id and dv.pessoa_ci_uf = 'SP' and dv.pessoa_ci_numero = '402265506' and empresa_cnpj = '01611213000112') order by ar.empresa_relatos_data desc, ar.empresa_relatos_id desc;
--select erp.empresa_relatos_id as id, dv.docente_visualizacao_data as data, erp.pessoa_ci_uf, erp.pessoa_ci_numero, ps.pessoa_nome from empresa_relatos_pessoas erp, empresa_relatos er, pessoa ps, docente_visualizacao dv where erp.empresa_relatos_id = er.empresa_relatos_id and (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (erp.pessoa_ci_uf, erp.pessoa_ci_numero) and dv.empresa_relatos_id = erp.empresa_relatos_id and dv.docente_visualizacao_status = true and pessoa_tipo = 'ALUNO(A)' and dv.pessoa_ci_uf = 'SP' and dv.pessoa_ci_numero = '402265506' and dv.empresa_cnpj = '01611213000112' order by dv.docente_visualizacao_data desc, dv.empresa_relatos_id desc;



--select * from empresa_relatos er, empresa_relatos_pessoas erp where erp.empresa_relatos_id = er.empresa_relatos_id  --ar.empresa_relatos_id, empresa_relatos_data, empresa_relatos_tipo1, pessoa_nome, empresa_nome




create sequence sid_docente_visualizacao;
create table docente_visualizacao(
  docente_visualizacao_id bigint NOT NULL primary key,
  docente_visualizacao_data date NOT NULL,
  docente_visualizacao_hora time without time zone NOT NULL,
  docente_visualizacao_status boolean,
  empresa_relatos_id integer not null references empresa_relatos (empresa_relatos_id), --15
  pessoa_ci_uf varchar(5) not null,--SP
  pessoa_ci_numero varchar(20) not null,--402265506
  empresa_cnpj varchar(20) not null references empresa (empresa_cnpj), --01611213000112
  constraint fk_docente_visualizacao_ci_uf_id FOREIGN KEY (pessoa_ci_uf, pessoa_ci_numero)
      REFERENCES pessoa (pessoa_ci_uf, pessoa_ci_numero) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
  

insert into docente_visualizacao values (nextval('sid_docente_visualizacao'),(select current_date), (select current_time),true,5,'SP','402265506','01611213000112');

--select dv.docente_visualizacao_data, dv.aluno_relatorio_id, ps.pessoa_nome, ep.empresa_nome from aluno_relatorio ar, docente_visualizacao dv, pessoa ps, empresa ep where ar.aluno_uf = ps.pessoa_ci_uf and ar.aluno_ra = ps.pessoa_ci_numero and dv.aluno_relatorio_id = ar.aluno_relatorio_id and dv.empresa_cnpj = ep.empresa_cnpj and dv.docente_visualizacao_status = true and ep.empresa_cnpj = '01611213000112' order by dv.docente_visualizacao_data, dv.aluno_relatorio_id;

--SELECT empresa_relatos_id, empresa_relatos_data, empresa_relatos_tipo, pessoa_nome, empresa_nome FROM  empresa_relatos ar, pessoa ps, empresa ep WHERE (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (ar.pessoa_ci_uf, ar.pessoa_ci_numero) and ep.empresa_cnpj = ar.empresa_cnpj and not EXISTS (SELECT * FROM docente_visualizacao dv WHERE dv.empresa_relatos_id = ar.empresa_relatos_id and dv.pessoa_ci_uf = 'SP' and dv.pessoa_ci_numero = '426099278' and empresa_cnpj = '01611213000112') order by aluno_relatorio_id desc;


--select * from empresa_relatos where empresa_cnpj = '01611213000112' and empresa_relatos_status = true and empresa_relatos_id = 20
--select erp.empresa_relatos_id, erp.empresa_relatos_pessoas_data, erp.pessoa_ci_uf, erp.pessoa_ci_numero, ps.pessoa_nome, erp.pessoa_tipo from empresa_relatos_pessoas erp, pessoa ps where erp.empresa_cnpj = '01611213000112' and erp.empresa_relatos_pessoas_status = true and (erp.pessoa_ci_uf, erp.pessoa_ci_numero) = (ps.pessoa_ci_uf, ps.pessoa_ci_numero) and erp.empresa_relatos_id = 20


--select acervo_relatar_id, acervo_relatar_data, acervo_tombo_empresa_numero, acervo_nome, empresa_nome from acervo_relatar ar, pessoa ps, empresa ep, acervo ac where acervo_relatar_status = true and (ps.pessoa_ci_uf, ps.pessoa_ci_numero) = (ar.pessoa_ci_uf, ar.pessoa_ci_numero) and ar.pessoa_ci_uf = 'SP' and ar.pessoa_ci_numero = '169009074' and ar.empresa_cnpj = ep.empresa_cnpj


--select ar.acervo_relatar_id, ar.pessoa_ci_uf, ar.pessoa_ci_numero, ps.pessoa_nome, ar.acervo_tombo_empresa_numero, ac.acervo_nome from acervo ac, pessoa ps, acervo_relatar ar, acervo_tombo_empresa ate where ac.acervo_isbn = ate.acervo_isbn and ar.pessoa_ci_uf = ps.pessoa_ci_uf and ar.pessoa_ci_numero = ps.pessoa_ci_numero and ate.acervo_tombo_empresa_numero = ar.acervo_tombo_empresa_numero and ate.empresa_cnpj = ar.empresa_cnpj and ar.acervo_relatar_status = true and ar.empresa_cnpj = '01611213000112' and ar.acervo_tombo_empresa_numero = '0466';


--###############################################################################################################################################

--Planejamento da Rotina Semanal

create sequence sid_planejamento_rotina_semanal;
create table planejamento_rotina_semanal(
  prs_id bigint NOT NULL primary key,
  prs_data date NOT NULL,
  prs_hora time without time zone NOT NULL,
  prs_status boolean,
  prs_data_semanal date not null,
  prs_caderno varchar(5),
  periodo_nome varchar(50) not null references periodo (periodo_nome),
  disciplina_nome varchar(50) not null references disciplina (disciplina_nome),
  pessoa_ci_uf varchar(5) NOT NULL,
  pessoa_ci_numero varchar(20) NOT NULL,
  classe_numero varchar(15) not null references classe (classe_numero),
  empresa_cnpj varchar(20) not null references empresa (empresa_cnpj),
  prs_descricao varchar not null,
  constraint fk_prs_pessoa_ci_uf_id FOREIGN KEY (pessoa_ci_uf, pessoa_ci_numero)
      REFERENCES pessoa (pessoa_ci_uf, pessoa_ci_numero) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

insert into planejamento_rotina_semanal values (1,(select current_date),(select current_time),true,'12/08/2014','1','MATUTINO','MATEMÁTICA','SP','402265506','1111111111','01611213000112','');

--select * from planejamento_rotina_semanal where prs_status = true and prs_id = 3 and pessoa_ci_uf = 'SP' and pessoa_ci_numero = '402265506' and empresa_cnpj = '01611213000112'


create sequence sid_planejamentors_visualizacao;
create table planejamentors_visualizacao(
  planejamentors_visualizacao_id bigint NOT NULL primary key,
  planejamentors_visualizacao_data date NOT NULL,
  planejamentors_visualizacao_hora time without time zone NOT NULL,
  planejamentors_visualizacao_status boolean,
  planejamento_rotina_semanal integer not null references planejamento_rotina_semanal (prs_id),
  --empresa_relatos_id integer not null references empresa_relatos (empresa_relatos_id), --15
  pessoa_ci_uf varchar(5) not null,--SP
  pessoa_ci_numero varchar(20) not null,--402265506
  empresa_cnpj varchar(20) not null references empresa (empresa_cnpj), --01611213000112
  constraint fk_planejamentors_visualizacao_ci_uf_id FOREIGN KEY (pessoa_ci_uf, pessoa_ci_numero)
      REFERENCES pessoa (pessoa_ci_uf, pessoa_ci_numero) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
  

insert into planejamentors_visualizacao values (nextval('sid_planejamentors_visualizacao'),(select current_date), (select current_time),true,1,'SP','402265506','01611213000112');

--########################################################################################################################################################################
--Carro


drop sequence sid_auto_marca_modelo_stilo;
drop table auto_marca_modelo_stilo;

drop sequence sid_auto_cor;
drop table auto_cor;

drop sequence sid_auto_combustivel;
drop table auto_combustivel;

drop sequence sid_auto_marca_modelo;
drop table auto_marca_modelo;

drop sequence sid_auto_tipo_marca;
drop table auto_tipo_marca;

drop sequence sid_auto_tipo;
drop table auto_tipo;

--Auto Tipo
create sequence sid_auto_tipo;
create table auto_tipo(
  auto_tipo_id bigint primary key,
  auto_tipo_data date not null,
  auto_tipo_hora time without time zone not null,
  auto_tipo_status boolean not null, 
  auto_tipo_nome varchar (30) unique,
  auto_tipo_descricao varchar(100)
);

insert into auto_tipo values (nextval('sid_auto_tipo'),(select current_date), (select current_time), true,'','');
insert into auto_tipo values (nextval('sid_auto_tipo'),(select current_date), (select current_time), true,'CARRO','');
insert into auto_tipo values (nextval('sid_auto_tipo'),(select current_date), (select current_time), true,'MOTO','');

--Auto Tipo Marca
create sequence sid_auto_tipo_marca;
create table auto_tipo_marca(
  auto_tipo_marca_id bigint primary key,
  auto_tipo_marca_data date not null,
  auto_tipo_marca_hora time without time zone not null,
  auto_tipo_marca_status boolean not null, 
  auto_tipo_nome varchar(30) references auto_tipo (auto_tipo_nome),
  auto_tipo_marca_nome varchar (30) not null,
  auto_tipo_marca_descricao varchar(100),
  constraint uq_tipo_marca unique (auto_tipo_nome, auto_tipo_marca_nome)
);

insert into auto_tipo_marca values (nextval('sid_auto_tipo_marca'),(select current_date), (select current_time), true,'','','');			
insert into auto_tipo_marca values (nextval('sid_auto_tipo_marca'),(select current_date), (select current_time), true,'CARRO','FORD','');
insert into auto_tipo_marca values (nextval('sid_auto_tipo_marca'),(select current_date), (select current_time), true,'CARRO','CHEVROLET','');
insert into auto_tipo_marca values (nextval('sid_auto_tipo_marca'),(select current_date), (select current_time), true,'CARRO','NISSAN','');
insert into auto_tipo_marca values (nextval('sid_auto_tipo_marca'),(select current_date), (select current_time), true,'CARRO','FIAT','');
insert into auto_tipo_marca values (nextval('sid_auto_tipo_marca'),(select current_date), (select current_time), true,'CARRO','HONDA','');
insert into auto_tipo_marca values (nextval('sid_auto_tipo_marca'),(select current_date), (select current_time), true,'CARRO','TOYOTA','');
insert into auto_tipo_marca values (nextval('sid_auto_tipo_marca'),(select current_date), (select current_time), true,'CARRO','VOLKSWAGEN','');
insert into auto_tipo_marca values (nextval('sid_auto_tipo_marca'),(select current_date), (select current_time), true,'CARRO','CHERY','');
insert into auto_tipo_marca values (nextval('sid_auto_tipo_marca'),(select current_date), (select current_time), true,'CARRO','HYUNDAI','');
insert into auto_tipo_marca values (nextval('sid_auto_tipo_marca'),(select current_date), (select current_time), true,'CARRO','PEUGEOT','');
insert into auto_tipo_marca values (nextval('sid_auto_tipo_marca'),(select current_date), (select current_time), true,'CARRO','KIA','');
insert into auto_tipo_marca values (nextval('sid_auto_tipo_marca'),(select current_date), (select current_time), true,'CARRO','CITROEN','');

--Auto Tipo Marca Modelo
create sequence sid_auto_tipo_marca_modelo;
create table auto_tipo_marca_modelo(
  auto_tipo_marca_modelo_id bigint primary key,
  auto_tipo_marca_modelo_data date not null,
  auto_tipo_marca_modelo_hora time without time zone not null,
  auto_tipo_marca_modelo_status boolean not null, 
  auto_tipo_nome varchar(30) references auto_tipo(auto_tipo_nome),
  auto_tipo_marca_nome varchar(30),
  auto_tipo_marca_modelo_nome varchar (50) not null,
  auto_tipo_marca_modelo_descricao varchar(100),
  constraint uq_tipo_marca_modelo unique (auto_tipo_nome, auto_tipo_marca_nome, auto_tipo_marca_modelo_nome)
);

insert into auto_tipo_marca_modelo values (nextval('sid_auto_tipo_marca_modelo'),(select current_date), (select current_time), true,'','','');
insert into auto_tipo_marca_modelo values (nextval('sid_auto_tipo_marca_modelo'),(select current_date), (select current_time), true,'CARRO','FORD','FIESTA','');
insert into auto_tipo_marca_modelo values (nextval('sid_auto_tipo_marca_modelo'),(select current_date), (select current_time), true,'CARRO','FORD','KA','');
insert into auto_tipo_marca_modelo values (nextval('sid_auto_tipo_marca_modelo'),(select current_date), (select current_time), true,'CARRO','CHEVROLET','PRISMA','');
insert into auto_tipo_marca_modelo values (nextval('sid_auto_tipo_marca_modelo'),(select current_date), (select current_time), true,'CARRO','FIAT','UNO','');
insert into auto_tipo_marca_modelo values (nextval('sid_auto_tipo_marca_modelo'),(select current_date), (select current_time), true,'CARRO','VOLKSWAGEN','GOL','');
insert into auto_tipo_marca_modelo values (nextval('sid_auto_tipo_marca_modelo'),(select current_date), (select current_time), true,'CARRO','TOYOTA','COROLLA','');

--Auto Tipo Marca Modelo Stilo
create sequence sid_auto_tipo_marca_modelo_stilo;
create table auto_tipo_marca_modelo_stilo(
  auto_tipo_marca_modelo_stilo_id bigint primary key,
  auto_tipo_marca_modelo_stilo_data date not null,
  auto_tipo_marca_modelo_stilo_hora time without time zone not null,
  auto_tipo_marca_modelo_stilo_status boolean not null, 
  auto_tipo_nome varchar(30) references auto_tipo(auto_tipo_nome),
  auto_tipo_marca_nome varchar(30),
  auto_tipo_marca_modelo_nome varchar (30),
  auto_tipo_marca_modelo_stilo_nome varchar (30) not null,
  auto_tipo_marca_modelo_stilo_descricao varchar(100),
  constraint uq_tipo_marca_modelo_stilo unique (auto_tipo_nome, auto_tipo_marca_nome, auto_tipo_marca_modelo_nome, auto_tipo_marca_modelo_stilo_nome)
);

insert into auto_tipo_marca_modelo_stilo values (nextval('sid_auto_tipo_marca_modelo_stilo'),(select current_date), (select current_time), true,'','','','','');
insert into auto_tipo_marca_modelo_stilo values (nextval('sid_auto_tipo_marca_modelo_stilo'),(select current_date), (select current_time), true,'CARRO','FORD','FIESTA','HATCH','');
insert into auto_tipo_marca_modelo_stilo values (nextval('sid_auto_tipo_marca_modelo_stilo'),(select current_date), (select current_time), true,'CARRO','FORD','FIESTA','SEDÃ','');

--Auto Combustível
create sequence sid_auto_combustivel;
create table auto_combustivel(
  auto_combustivel_id bigint primary key,
  auto_combustivel_data date not null,
  auto_combustivel_hora time without time zone not null,
  auto_combustivel_status boolean not null, 
  auto_combustivel_nome varchar (30) unique,
  auto_combustivel_descricao varchar(100)
);

insert into auto_combustivel values (nextval('sid_auto_combustivel'),(select current_date), (select current_time), true,'','');
insert into auto_combustivel values (nextval('sid_auto_combustivel'),(select current_date), (select current_time), true,'ETANOL','');
insert into auto_combustivel values (nextval('sid_auto_combustivel'),(select current_date), (select current_time), true,'GASOLINA','');
insert into auto_combustivel values (nextval('sid_auto_combustivel'),(select current_date), (select current_time), true,'DIESEL','S500 OU S10');
insert into auto_combustivel values (nextval('sid_auto_combustivel'),(select current_date), (select current_time), true,'GAS','');
insert into auto_combustivel values (nextval('sid_auto_combustivel'),(select current_date), (select current_time), true,'FLEX','ETANOL/GASOLINA');

--Auto Cor
create sequence sid_auto_cor;
create table auto_cor(
  auto_cor_id bigint primary key,
  auto_cor_data date not null,
  auto_cor_hora time without time zone not null,
  auto_cor_status boolean not null, 
  auto_cor_nome varchar (30) unique,
  auto_cor_descricao varchar(100)
);

insert into auto_cor values (nextval('sid_auto_cor'),(select current_date), (select current_time), true,'','');
insert into auto_cor values (nextval('sid_auto_cor'),(select current_date), (select current_time), true,'BRANCO','');
insert into auto_cor values (nextval('sid_auto_cor'),(select current_date), (select current_time), true,'PRETO','');
insert into auto_cor values (nextval('sid_auto_cor'),(select current_date), (select current_time), true,'CINZA','');
insert into auto_cor values (nextval('sid_auto_cor'),(select current_date), (select current_time), true,'AZUL','');
insert into auto_cor values (nextval('sid_auto_cor'),(select current_date), (select current_time), true,'VERMELHO','');



