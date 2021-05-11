--select current_date;
select ra_dpalunos, rm_dpalunos, nome_dpalunos,dn_dpalunos, (((select current_date)-dn_dpalunos)/365) as nn  from dp_alunos order by 5,3


insert into rg values (nextval('sid_rg'),(select current_date), (select current_time), true, '28/01/2002','SP','40226550-6','SP','FERNANDOPOLIS','FERNANDOPOLIS','A69','122','016994')
