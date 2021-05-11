use demo;
create table Permision(

id int(11) auto_increment primary key,

name varchar(50)

);
drop table Permision;

insert into Permision(name) values('add');

insert into Permision(name) values('edit');

insert into Permision(name) values('delete');

insert into Permision(name) values('view');
