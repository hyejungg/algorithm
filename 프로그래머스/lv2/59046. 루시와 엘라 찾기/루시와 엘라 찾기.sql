-- 코드를 입력하세요
# select animal_id, name, sex_upon_intake
# from animal_ins
# where name = 'Lucy' 
# or name = 'Ella'
# or name = 'Pickle'
# or name = 'Rogan'
# or name = 'Sabrina'
# or name = 'Mitty';

select animal_id, name, sex_upon_intake
from animal_ins
where 'Lucy, Ella, Pickle, Rogan, Sabrina, Mitty' like concat('%', name, '%');