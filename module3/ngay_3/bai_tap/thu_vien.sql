create database Library;
use Library;

create table category(
cate_number int not null auto_increment primary key,
cate_name varchar(50) not null
);
insert into category(cate_name)
value('Sinh'), ('Toan'), ('Ngu Van'), ('Anh Van'), ('Dia Ly');

create table student(
student_number int not null auto_increment primary key,
student_name varchar(50) not null,
address varchar(50) not null,
email varchar(50) not null,
image_student varchar(50) not null
);
insert into student(student_name, address, email, image_student)
values	('Quang', 'Da Nang', 'quang@gmail.com', 'anh cua Quang'),
		('Hoang', 'Quang Nam', 'hoang@gmail.com', 'anh cua Hoang'),
		('Thuan', 'Hue', 'thuan@gmail.com', 'anh cua Thuan'),
		('Vi', 'Da Nang', 'vi@gmail.com', 'anh cua Vi'),
		('Ngoc', 'Quang Tri', 'ngoc@gmail.com', 'anh cua Ngoc');


create table book(
book_number int not null auto_increment primary key,
book_name varchar(50) not null,
company_release varchar(50) not null,
year_release year not null,
numOf_release int not null,
price float not null, 
image_book varchar(50) not null,
cate_number int not null,
foreign key(cate_number) references category(cate_number)
);
insert into book(book_name, company_release, year_release, numOf_release, price, image_book, cate_number)
values 	('ngu_van_lop9', 'giao_duc', 2000, 100, 23.500, 'sach ngu van', 1),
		('Dia_ly_lop9', 'giao_duc', 2002, 200, 24.500, 'sach dia ly', 2),
		('Toan_lop9', 'kim_dong', 2004, 300, 26.500, 'sach toan', 3),
		('Sinh_lop9', 'tre', 2003, 600, 30.500, 'sach sinh', 4),
		('ngu_van_lop8', 'giao_duc', 1999, 100, 21.500, 'sach ngu van', 5);

create table borroworder(
card_number int not null auto_increment primary key,
student_name varchar(50) not null,
dateOf_birth date not null, 
address varchar(50) not null,
email varchar(50) not null,
phone text not null,
image varchar(50) not null,
status_borrow varchar(50) not null,
date_borrow date not null,
date_return date not null, 
student_number int not null,
foreign key(student_number) references student(student_number)
);
insert into borroworder(student_name, dateOf_birth, address, email, phone, image, status_borrow, date_borrow, date_return, student_number)
values  ('Quang', '1993-08-20', 'Da Nang', 'quang@gmail.com', 1234, 'anh cua Quang', 'chua tra', '2020-04-20', '2020-04-25', 1),
		('Hoang', '1995-10-24', 'Quang Nam', 'hoang@gmail.com', 12345, 'anh cua Hoang', 'da tra', '2020-04-25', '2020-04-30', 2),
        ('Thuan', '1997-02-23', 'Hue', 'thuan@gmail.com', 123489, 'anh cua Thuan', 'chua tra', '2020-05-20', '2020-05-21', 3),
        ('Vi', '1992-05-25', 'Da Nang', 'vi@gmail.com', 123432, 'anh cua Vi', 'da tra', '2020-05-15', '2020-06-02', 4),
        ('Ngoc', '1995-04-20', 'Hue', 'ngoc@gmail.com', 123478, 'anh cua Ngoc', 'da tra', '2020-04-12', '2020-04-21', 5);

create table book_student(
book_number int not null,
student_number int not null,
primary key(book_number, student_number),
foreign key(book_number) references book(book_number),
foreign key(student_number) references student(student_number)
);
insert into book_student(book_number, student_number)
values (1, 1), (2, 2), (3, 3), (4, 4), (5, 5);






