select p.product_name, s.year, s.price from Sales s inner join Product p
where s.product_id = p.product_id