-- 집계함수는 select 위치에서만 가능, where 절에서 쓰고 싶다면 서브쿼리 이용하기
select product_id, product_name, product_cd, category, price
from food_product
where price = (
    select max(price) from food_product
);