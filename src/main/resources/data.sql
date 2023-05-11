INSERT INTO bussines_groups (brand_id, brand_name)
VALUES (1, 'ZARA');

INSERT INTO products (product_id, product_name)
VALUES (35455, 'ABC');

INSERT INTO prices (id, start_date, end_date, rate, priority, price, curr, product_id, brand_id)
VALUES (1001,'2020-06-14 15.00.00','2020-06-14 18.30.00',2,1,25.45,'EUR',35455,1);

INSERT INTO prices (id, start_date, end_date, rate, priority, price, curr, product_id, brand_id)
VALUES (1002,'2020-06-15 00.00.00','2020-06-15 11.00.00',3,1,30.50,'EUR',35455,1);

INSERT INTO prices (id, start_date, end_date, rate, priority, price, curr, product_id, brand_id)
VALUES (1003,'2020-06-14 00.00.00','2020-12-31 23.59.59',1,0,35.50,'EUR',35455,1);

INSERT INTO prices (id, start_date, end_date, rate, priority, price, curr, product_id, brand_id)
VALUES (1004,'2020-06-15 16.00.00','2020-12-31 23.59.59',4,1,38.95,'EUR',35455,1);