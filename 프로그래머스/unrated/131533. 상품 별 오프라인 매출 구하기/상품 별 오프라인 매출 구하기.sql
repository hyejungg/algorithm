-- 코드를 입력하세요
select p.product_code, (p.price * o.sales_amount) as sales
from product p inner join (
    select product_id, sum(sales_amount) as sales_amount
    from offline_sale
    group by product_id
) o
on p.product_id = o.product_id
order by sales desc, p.product_code asc;
