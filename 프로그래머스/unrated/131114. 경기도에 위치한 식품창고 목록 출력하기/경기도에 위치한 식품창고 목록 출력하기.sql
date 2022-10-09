-- 문제를 제발 똑바로 읽자. 경 기 도
select warehouse_id, warehouse_name, address, ifnull(freezer_yn, 'N') freezer_yn
from food_warehouse
where address like '%경기도%'
order by warehouse_id asc;