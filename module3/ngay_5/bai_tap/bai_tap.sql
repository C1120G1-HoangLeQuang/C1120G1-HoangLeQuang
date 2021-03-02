create database demo;

use demo;
create table Products(
Id int not null auto_increment primary key,
productCode int not null,
productName varchar(45) not null,
productPrice int not null,
productAmount int not null,
productDescription varchar(45) not null,
productStatus varchar(45) not null
);

insert into Products(productCode, productName, productPrice, productAmount, productDescription, productStatus)
values	(123, 'SamSung', 12000, 45, 'TV', 'Available'),
		(223, 'Iphone', 32000, 25, 'Dien thoai', 'Not Available'),
        (423, 'LG', 20000, 21, 'TV', 'Available'),
        (543, 'Panasonic', 78000, 12, 'May Giat', 'Not Available'),
        (333, 'Viettel', 14000, 65, 'Wifi', 'Available'),
        (583, 'FPT', 19000, 11, 'Dien thoai', 'Available');
        
/* tao chi muc */
create unique index idx_productCode
on Products(productCode);

create index idx_Name_Price
on Products(productName, productPrice);

explain select * from Products where productName = 'SamSung' and productPrice = '12000';

/* tao view */
create view product_view as
select productCode, productName, productPrice, productStatus from Products;
select * from product_view;

update product_view
set productName = 'VNPT'
where productCode = 333;

drop view product_view;

/* tao store procedure */
delimiter //
create procedure getAllInformation() /* lấy tất cả thông tin của tất cả các sản phẩm trong bảng product */
begin 
select * from Products;
end //
delimiter ;

call getAllInformation();

delimiter //
create procedure addNewProduct()  /* thêm một sản phẩm mới */
begin 
insert into Products(productCode, productName, productPrice, productAmount, productDescription, productStatus)
values (222, 'Nokia', 2000, 25, 'Phone', 'Available');
end //
delimiter ;

call addNewProduct();

delimiter //
create procedure editProductById2(in in_id int) /* sửa thông tin sản phẩm theo id */
begin 
update Products
set productPrice = 40000 , productAmount = 30
where Id = in_id;
end //
delimiter ;

call editProductById2(6);
call getAllInformation();

delimiter //
create procedure deleteProductById(in Id_delete int) /* xoá sản phẩm theo id */
begin 
delete from Products
where Id = Id_delete;
end //
delimiter ;

call deleteProductById(7);
call getAllInformation();






