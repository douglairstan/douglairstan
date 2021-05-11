--select * from pessoa where pessoa_ci_numero like('%/%') and pessoa_status = true
update acervo_relatar set tmp = 'taysa' where pessoa_ci_numero = '11085531155';
update acervo_relatar set pessoa_ci_numero = '1108531155' where tmp = 'taysa';
update pessoa set pessoa_status = false where pessoa_ci_numero = '11085531155';