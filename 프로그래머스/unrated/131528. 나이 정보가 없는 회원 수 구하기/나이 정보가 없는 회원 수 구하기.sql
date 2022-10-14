-- count(*) 은 null 포함, count(칼럼명) 은 null 미포함
SELECT count(*) - count(age) as users 
from user_info;