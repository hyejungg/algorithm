-- 코드를 입력하세요
select o.animal_id, o.name 
from animal_outs o inner join animal_ins i
on o.animal_id = i.animal_id
where o.datetime < i.datetime
order by i.datetime;