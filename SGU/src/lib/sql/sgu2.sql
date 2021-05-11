-- Sequence: sid_dfalunos

-- DROP SEQUENCE sid_dfalunos;

CREATE SEQUENCE sid_dfalunos
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE sid_dfalunos OWNER TO postgres;

-- Sequence: sid_dpalunos

-- DROP SEQUENCE sid_dpalunos;

CREATE SEQUENCE sid_dpalunos
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE sid_dpalunos OWNER TO postgres;

-- Sequence: sid_his_alunos

-- DROP SEQUENCE sid_his_alunos;

CREATE SEQUENCE sid_his_alunos
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE sid_his_alunos OWNER TO postgres;

-- Sequence: sid_his_escola

-- DROP SEQUENCE sid_his_escola;

CREATE SEQUENCE sid_his_escola
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE sid_his_escola OWNER TO postgres;

-- Sequence: sid_regmatr

-- DROP SEQUENCE sid_regmatr;

CREATE SEQUENCE sid_regmatr
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE sid_regmatr OWNER TO postgres;

-- Table: escola

-- DROP TABLE escola;

CREATE TABLE escola
(
  id_escola bigint NOT NULL,
  codigo_escola character varying(15) NOT NULL,
  nome_escola character varying(100) NOT NULL,
  CONSTRAINT pk_escola PRIMARY KEY (id_escola, codigo_escola),
  CONSTRAINT uq_codigo_escola UNIQUE (codigo_escola),
  CONSTRAINT uq_id_escola UNIQUE (id_escola)
) 
WITHOUT OIDS;
ALTER TABLE escola OWNER TO postgres;

-- Table: dp_alunos

-- DROP TABLE dp_alunos;

CREATE TABLE dp_alunos
(
  id_dpalunos bigint NOT NULL,
  ra_dpalunos character varying(15) NOT NULL,
  prenome_dpalunos character varying(100) NOT NULL,
  sobrenome_dpalunos character varying(50) NOT NULL,
  agnome_dpalunos character varying(50),
  nomecompleto_dpalunos character varying(200) NOT NULL,
  dn_dpalunos date NOT NULL,
  excluido_dpalunos boolean NOT NULL,
  CONSTRAINT pk_id_ra_dpalunos PRIMARY KEY (id_dpalunos, ra_dpalunos),
  CONSTRAINT uq_id_ra_dpalunos UNIQUE (id_dpalunos),
  CONSTRAINT uq_ra_dpalunos UNIQUE (ra_dpalunos)
) 
WITHOUT OIDS;
ALTER TABLE dp_alunos OWNER TO postgres;
COMMENT ON TABLE dp_alunos IS 'Dados Pessoais dos Alunos';

-- Table: df_alunos

-- DROP TABLE df_alunos;

CREATE TABLE df_alunos
(
  id_dfalunos bigint NOT NULL,
  ra_dpalunos character varying(15) NOT NULL,
  sexo_dfalunos character varying(20) NOT NULL,
  CONSTRAINT pk_id_dfalunos PRIMARY KEY (id_dfalunos, ra_dpalunos),
  CONSTRAINT fk_ra_dpalunos FOREIGN KEY (ra_dpalunos)
      REFERENCES dp_alunos (ra_dpalunos) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uq_id_dfalunos UNIQUE (id_dfalunos),
  CONSTRAINT uq_ra_dpalunos_df UNIQUE (ra_dpalunos)
) 
WITHOUT OIDS;
ALTER TABLE df_alunos OWNER TO postgres;
COMMENT ON TABLE df_alunos IS 'Dados Físicos dos Alunos';

-- Table: fl_alunos

-- DROP TABLE fl_alunos;

CREATE TABLE fl_alunos
(
  id_flalunos bigint NOT NULL,
  ra_dpalunos character varying(15) NOT NULL,
  pai_flalunos character varying(100),
  situacao_pai_flalunos boolean,
  CONSTRAINT pk_flalunos PRIMARY KEY (id_flalunos, ra_dpalunos),
  CONSTRAINT fk_ra_dpalunos FOREIGN KEY (ra_dpalunos)
      REFERENCES dp_alunos (ra_dpalunos) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uq_idflalunos UNIQUE (id_flalunos),
  CONSTRAINT uq_radpalunos UNIQUE (ra_dpalunos)
) 
WITHOUT OIDS;
ALTER TABLE fl_alunos OWNER TO postgres;
COMMENT ON TABLE fl_alunos IS 'Filiação dos Alunos';

-- Table: historico_alunos

-- DROP TABLE historico_alunos;

CREATE TABLE historico_alunos
(
  id_hisalunos bigint NOT NULL,
  data_hisalunos date NOT NULL,
  time_hisalunos time without time zone NOT NULL,
  ra_dpalunos character varying(15) NOT NULL,
  prenome_dpalunos character varying(100),
  sobrenome_dpalunos character varying(50),
  agnome_dpalunos character varying(50),
  nomecompleto_dpalunos character varying(200),
  dn_dpalunos date,
  sexo_dfalunos character varying(20),
  excluido_dpalunos boolean NOT NULL,
  CONSTRAINT pk_id_hisalunos PRIMARY KEY (id_hisalunos)
) 
WITHOUT OIDS;
ALTER TABLE historico_alunos OWNER TO postgres;

-- Table: registro_matricula

-- DROP TABLE registro_matricula;

CREATE TABLE registro_matricula
(
  id_regmatr bigint NOT NULL,
  codigo_escola character varying(15) NOT NULL,
  ra_dpalunos character varying(15) NOT NULL,
  rm_regmatr integer NOT NULL,
  CONSTRAINT pk_id_rm_regmatr PRIMARY KEY (id_regmatr, rm_regmatr),
  CONSTRAINT fk_codigo_escola FOREIGN KEY (codigo_escola)
      REFERENCES escola (codigo_escola) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_ra_dpalunos FOREIGN KEY (ra_dpalunos)
      REFERENCES dp_alunos (ra_dpalunos) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uq_id_ra_rm UNIQUE (codigo_escola, ra_dpalunos, rm_regmatr),
  CONSTRAINT uq_ra_dpalunos_regmatr UNIQUE (ra_dpalunos),
  CONSTRAINT uq_rm_codigo UNIQUE (rm_regmatr, codigo_escola)
) 
WITHOUT OIDS;
ALTER TABLE registro_matricula OWNER TO postgres;































