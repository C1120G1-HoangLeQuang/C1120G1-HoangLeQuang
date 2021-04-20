create database Casestudy4;
drop database Casestudy4;

use Casestudy4;

create table positions(
position_id int not null auto_increment primary key, 
position_name varchar(45) not null
);

create table education_degree(
education_degree_id int not null auto_increment primary key,
education_degree_name varchar(45) not null
);

create table division(
division_id int not null auto_increment primary key,
division_name varchar(45) not null
);

create table customer_type(
customer_type_id int not null auto_increment primary key,
customer_type_name varchar(45) not null
);

create table rent_type(
rent_type_id int not null auto_increment primary key,
rent_type_name varchar(45) not null,
rent_type_cost int
);

create table service_type(
service_type_id int not null auto_increment primary key,
service_type_name varchar(45) not null
);

create table attach_service(
attach_service_id int not null auto_increment primary key,
attach_service_name varchar(45) not null,
attach_service_cost int not null,
attach_service_unit int not null,
attach_service_status varchar(45) not null
);

create table roles(
role_id int not null auto_increment primary key,
role_name varchar(255) not null
);

create table users(
username varchar(255) not null primary key,
passwords varchar(255) not null
);

create table user_role(
role_id int not null,
foreign key(role_id) references roles(role_id) on update cascade on delete cascade,
username varchar(255) not null, 
foreign key(username) references users(username) on update cascade on delete cascade
);

create table employee(
employee_id int not null auto_increment primary key,
employee_name varchar(45) not null,
position_id int not null,
foreign key(position_id) references positions(position_id) on update cascade on delete cascade,
education_degree_id int not null,
foreign key(education_degree_id) references education_degree(education_degree_id) on update cascade on delete cascade,
division_id int not null,
foreign key(division_id) references division(division_id) on update cascade on delete cascade,
username varchar(255) not null, 
foreign key(username) references users(username) on update cascade on delete cascade,
employee_birthday varchar(45) not null,
employee_id_card varchar(45) not null,
employee_salary double not null,
employee_phone varchar(45) not null,
employee_email varchar(45) not null,
employee_address varchar(45) not null
);

create table customer(
customer_id varchar(45) not null primary key,
customer_type_id int not null,
foreign key(customer_type_id) references customer_type(customer_type_id) on update cascade on delete cascade,
customer_name varchar(45) not null,
customer_birthday varchar(45) not null,
customer_gender bit(1) not null,
customer_id_card varchar(45) not null,
customer_phone varchar(45) not null,
customer_email varchar(45) not null,
customer_address varchar(45) not null
);

create table service(
service_id varchar(45) not null primary key,
service_name varchar(45) not null,
service_area int not null,
service_max_people int not null,
service_cost double not null,
rent_type_id int not null,
foreign key(rent_type_id) references rent_type(rent_type_id) on update cascade on delete cascade,
service_type_id int not null,
foreign key(service_type_id) references service_type(service_type_id) on update cascade on delete cascade,
standard_room varchar(45), 
description_other_convenience varchar(45),
pool_area double,
number_of_floors int
);


create table contract(
contract_id int not null auto_increment primary key,
employee_id int not null,
foreign key(employee_id) references employee(employee_id) on update cascade on delete cascade,
customer_id varchar(45) not null,
foreign key(customer_id) references customer(customer_id) on update cascade on delete cascade,
service_id varchar(45) not null,
foreign key(service_id) references service(service_id) on update cascade on delete cascade,
contract_start_date varchar(45) not null,
contract_end_date varchar(45) not null, 
contract_deposit double not null,
contract_total double not null
);


create table contract_detail(
contract_detail_id int not null auto_increment primary key,
contract_id int not null,
foreign key(contract_id) references contract(contract_id) on update cascade on delete cascade,
attach_service_id int not null,
foreign key(attach_service_id) references attach_service(attach_service_id) on update cascade on delete cascade,
quantity int not null
);