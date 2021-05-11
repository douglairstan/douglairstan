﻿drop table lf;

create table lf(
  id bigint,
  n1 integer,
  n2 integer,
  n3 integer,
  n4 integer,
  n5 integer,
  n6 integer,
  n7 integer,
  n8 integer,
  n9 integer,
  n10 integer,
  n11 integer,
  n12 integer,
  n13 integer,
  n14 integer,
  n15 integer,
  soma integer,
  constraint uq_lf unique (n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15)
  );

  --insert into lf values ((select count(id)+1 from lf),n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, soma);

--select soma,  count(*) from lf group by soma order by 2 desc, 1 desc
--select * from lf where n1 = 1 and n2 = 2 and n3 = 3 and n4 = 5 and n5 = 6 and n15 = 25 and soma = 199
--select * from lf where n1 = 1 and n2 = 2 and n3 = 3 and n4 = 5 and n5 = 6 and n15 = 25 and soma = 166 --1,2,3,6,7


create table lfms(
  id bigint,
  n1 integer,
  n2 integer,
  n3 integer,
  n4 integer,
  n5 integer,
  n6 integer,
  soma integer,
  constraint uq_lfms unique (n1, n2, n3, n4, n5, n6)
  );

  --insert into lfms values ((select count(id)+1 from lf),n1, n2, n3, n4, n5, n6, soma);
