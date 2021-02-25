create database thuc_hanh_1;
create table contacts(
contact_id int(20) Not null Auto_increment,
last_name varchar(30) Not null,
first_name varchar(30),
birthday date,
constraint contacts_pk Primary key (contact_id)
); 
create table suppliers(
supplier_id int(11) Not null Auto_increment,
supplier_name varchar(50) not null,
account_rep varchar(30) Not null Default 'TBD',
Constraint supplier_pk Primary Key (supplier_id)
);