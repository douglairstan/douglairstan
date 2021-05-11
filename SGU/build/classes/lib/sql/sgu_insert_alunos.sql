--insert into dp_alunos values (nextval('sid_dpalunos'), '040.226.550-6', 'DOUGLAS ESTANISLAU','PEREIRA','','DOUGLAS ESTANISLAU PEREIRA','17/10/87',FALSE);
--insert into df_alunos values (nextval('sid_dfalunos'), '040.226.550-6','MASCULINO');
--insert into historico_alunos values (nextval('sid_his_alunos'), (select current_date), (select current_time), '040.226.550-6','DOUGLAS ESTANISLAU','PEREIRA','','DOUGLAS ESTANISLAU PEREIRA','17/10/1987','MASCULINO',FALSE);
--insert into registro_matricula values (nextval('sid_regmatr'),'1','040.226.550-6',1);
--select rm.rm_regmatr as rm, dpa.nomecompleto_dpalunos as nome, dpa.ra_dpalunos as ra, dfa.sexo_dfalunos as sexo, dpa.dn_dpalunos as nascimento , (((select current_date)-dpa.dn_dpalunos)/365) as idade from dp_alunos dpa, df_alunos dfa, registro_matricula rm where dpa.ra_dpalunos = dfa.ra_dpalunos and dpa.ra_dpalunos = rm.ra_dpalunos and dpa.excluido_dpalunos = FALSE and dpa.nomecompleto_dpalunos like ('%%') order by 2
select max(rm_regmatr)+1 as maior from registro_matricula;

