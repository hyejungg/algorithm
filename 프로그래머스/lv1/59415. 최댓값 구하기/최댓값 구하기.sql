-- 코드를 입력하세요
# select datetime from animal_ins order by datetime desc limit 1;
# select a.datetime from (select datetime from animal_ins order by datetime desc) a limit 1;
select max(datetime) from animal_ins limit 1;