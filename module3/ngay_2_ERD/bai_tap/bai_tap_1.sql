create database bai_tap_1;
use bai_tap_1;
create table customers(
	customer_id int Primary key,
    fullname varchar(50), 
    address varchar(50),
    email varchar(50),
    phone varchar(50)
);    
create table acccounts(
	account_number varchar(30) Primary key,
    customer_id int, 
    foreign key (customer_id) references customers(customer_id),
    account_type varchar(50), 
    date_open date,
    balance varchar(50)
);  
create table transactions(
	tran_number varchar(20) Primary key,
    account_number varchar(30),
    foreign key (account_number) references acccounts(account_number),
    account_number_to varchar(50), 
    tran_date date,
    tran_money varchar(50),
    tran_description varchar(50)
);  