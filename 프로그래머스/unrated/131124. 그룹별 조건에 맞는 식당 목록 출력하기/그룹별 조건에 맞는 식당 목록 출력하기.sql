select member_name, review_text, review_date
from member_profile as m
inner join rest_review r
on m.member_id = r.member_id 
where m.member_id in (
    select member_id from rest_review
        group by member_id
        having count(review_id) = (
                                    select count(review_id) 
                                    from rest_review
                                    group by member_id
                                    order by count(review_id) desc
                                    limit 1
                                  )
        order by count(review_id) desc
)
order by review_date asc;