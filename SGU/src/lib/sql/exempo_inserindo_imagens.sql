insert into imagem_obra (fid_fco, jpg_grande) values ('6236', lo_import('".addslashes($arq)."'))





create domain lo as oid;

--Vamos criar uma tabela em que há um campo
--para o nome da figura e outro para a figura propriamente dita:

CREATE TABLE imagem
(
nome varchar(30) NOT NULL PRIMARY KEY, 
figura lo
)

--Para inserir a imagem utilizamos a função
--lo_import() para capturarmos a figura:

INSERT INTO imagem (nome, figura) VALUES ('figura1.jpg', lo_import('c:/figuras/figura.jpg'));

--Para extrair a figura, você terá que
--criar uma cópia desta figura em alguma pasta temporária
--utilizando a função lo_export():

SELECT lo_export(figura, 'c:/temp/figura1.jpg') FROM imagem WHERE nome = 'figura1.jpg';


-- site: http://imasters.com.br/artigo/1779/
