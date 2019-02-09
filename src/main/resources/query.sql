/*Create Country Table*/
CREATE TABLE IF NOT EXISTS country (coun_id BIGINT PRIMARY KEY, country_name VARCHAR(100));

/*Create Customer Table*/
CREATE TABLE IF NOT EXISTS customer (cust_id BIGINT PRIMARY KEY, country_code BIGINT, name VARCHAR(100),
FOREIGN KEY(country_code) REFERENCES country(coun_id));

/*Create FIND_CUSTOM_CUSTOMER_BY_ID Procedure*/
DELIMITER $$
CREATE PROCEDURE FIND_CUSTOM_CUSTOMER_BY_ID(IN cust_id BIGINT)
BEGIN
SELECT a.cust_id, a.name as full_name, b.country_name as country
from customer as a left join country as b 
on b.coun_id = a.country_code where a.cust_id = cust_id;
END
$$ 

/*Create INSERT_COUNTRY Procedure`*/
DELIMITER $$
CREATE PROCEDURE INSERT_CUSTOMER(IN num BIGINT)
BEGIN
DECLARE total INT unsigned DEFAULT 0;
WHILE total <= num DO
INSERT INTO customer values(total+1, 1, CONCAT('customer',total+1));
SET total = total +1;
END WHILE;
END
$$

/*Inserting Data Into Tables*/
INSERT INTO country VALUES (1, 'Indonesia'),(2, 'Russia'),(3, 'China'),(4, 'USA'),(5, 'UK');

CALL INSERT_CUSTOMER(10000);