color A
pg_dump.exe -i -h localhost -p 5432 -U postgres -F c -b -v -f "C:\SGU\backup\sgu_%date:~6,4%%date:~3,2%%date:~0,2%_%time:~0,2%%time:~3,2%.backup" "sgu"
exit