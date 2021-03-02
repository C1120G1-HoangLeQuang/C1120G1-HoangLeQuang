SELECT * FROM classicmodels.customers;

/* tham so IN */
delimiter //
create procedure getCusById(in cusNum int(11))
begin
select * from customers where customerNumber = cusNum;
end //
delimiter ;

call getCusById(175);

/* tham so OUT */
delimiter //
create procedure GetCustomersCountByCity(in in_city varchar(45), out total int) 
begin
select count(customerNumber) 
into total
from customers
where city = in_city;
end //
delimiter ;

call GetCustomersCountByCity('Lyon', @total);
select @total;

/* tham so OUT */
delimiter //
create procedure SetCounter(inout counter int, in inc int)
begin
set counter = counter + inc;
end //
delimiter ;

SET @counter = 1;

CALL SetCounter(@counter,1); -- 2

CALL SetCounter(@counter,1); -- 3

CALL SetCounter(@counter,5); -- 8

SELECT @counter; -- 8












