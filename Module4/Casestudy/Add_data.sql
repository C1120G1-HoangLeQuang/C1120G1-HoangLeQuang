insert into positions(position_name)
values  ('Giam Doc'), ('Quan Ly'), ('Giam Sat'), ('Chuyen Vien'), ('Phuc Vu'), ('Le Tan');

insert into education_degree(education_degree_name)
values('Trung Cap'), ('Cao Dang'), ('Dai Hoc'), ('Sau Dai Hoc');

insert into division(division_name)
values('Sale Marketing'), ('Hanh Chinh'), ('Phuc Vu'), ('Quan Ly');

insert into customer_type(customer_type_name)
values('Diamond'), ('Platinium'), ('Gold'), ('Silver'), ('Members');

insert into rent_type(rent_type_name, rent_type_cost)
values('Year', 140000), ('Month', 15000), ('Day', 500), ('Hour', 100);

insert into service_type(service_type_name)
values('Villa'), ('House'), ('Room');

insert into attach_service(attach_service_name, attach_service_cost, attach_service_unit, attach_service_status)
values 	('Massage', 35, 1, 'Available'),
		('Karaoke', 10, 1, 'Available'),
        ('Food', 25, 1, 'Available'),
        ('Drink', 10, 1, 'Available'),
        ('RentalCar', 40, 1, 'Available');
        
insert into roles(role_name)      
values 	('ROLE_ADMIN'),
		('ROLE_GIAMDOC'),
		('ROLE_QUANLY'),
        ('ROLE_GIAMSAT'),
        ('ROLE_NHANVIEN'),
        ('ROLE_NGUOIDUNG');
        
insert into roles(role_name)      
values 	('ROLE_ADMIN1'),
		('ROLE_GIAMDOC1'),
		('ROLE_QUANLY1'),
        ('ROLE_GIAMSAT1'),
        ('ROLE_NHANVIEN1'),
        ('ROLE_NGUOIDUNG1');
        
insert into users(username, passwords)
values 	('admin', 'admin'),
		('giamdoc', 'giamdoc'),
        ('quanly', 'quanly'),
        ('giamsat', 'giamsat'),
        ('nhanvien', 'nhanvien'),
        ('nguoidung', 'nguoidung');

insert into users(username, passwords)
values 	('admin1', 'admin1'),
		('giamdoc1', 'giamdoc1'),
        ('quanly1', 'quanly1'),
        ('giamsat1', 'giamsat1'),
        ('nhanvien1', 'nhanvien1'),
        ('nguoidung1', 'nguoidung1');
        
insert into user_role(role_id, username)
values	(1, 'admin'),
		(2, 'giamdoc'),
        (3, 'quanly'),
        (4, 'giamsat'),
        (5, 'nhanvien'),
        (6, 'nguoidung');
        
insert into user_role(role_id, username)
values	(7, 'admin1'),
		(8, 'giamdoc1'),
        (9, 'quanly1'),
        (10, 'giamsat1'),
        (11, 'nhanvien1'),
        (12, 'nguoidung1');
        
insert into employee(employee_name, position_id, education_degree_id, division_id, username, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address)  
values 	('Trần Quốc Hoàng', 1, 2, 4, 'giamdoc','1995/12/12', '123123123', '300000', '0909123111', 'hoangtq@gmail.com', 'Quảng Nam'),
		('Ngọc Thuần', 2, 2, 4, 'quanly','2000/10/05', '123123444', 400000, '0909123121', 'thuanng@gmail.com', 'TP HCM'),
		('Lê Quang',  3, 3, 4, 'giamsat','1998/02/11', '123123555', 900000, '0909123345', 'quangle@gmail.com', 'Huế'),
		('Trần Hoàng Sang',  4, 2, 2, 'nhanvien','1995/04/04', '123123777', '300000', '0909123333', 'sangth@gmail.com', 'Quảng Bình'),
		('Bùi Khoa',  2, 3, 2, 'admin','1999/04/25', '123123999', '250000', '0909123222', 'khoa@gmail.com', 'Quảng Trị'),
		('Doãn Chí Bình', 6, 1, 3, 'nguoidung','1992/10/05', '123123446', 100000, '0909123121', 'binh@gmail.com', 'TP HCM'); 
		
insert into customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address)
values	('KH-1111', 3, 'Rosicky','1995/04/05', 1, '345345345', 0908111222, 'tomas@gmail.com','Czech'),
		('KH-2222', 3, 'Arteta', '2000/03/05', 1, '111222333', 0908111333, 'mikel@gmail.com', 'Spain'),
		('KH-3333', 2, 'Wenger', '2001/11/11', 1, '343444555', 0908111444, 'wenger@gmail.com', 'France'),
		('KH-4444', 1, 'Gemma Atkinson', '2001/04/05', 0, '111111111', 0908111545, 'gemmath@gmail.com', 'England'),
		('KH-5555', 2, 'Cheryl Cole', '1994/12/12', 0, '020202021', 0908111666,'coleth@gmail.com','USA'), 
        ('KH-6666', 4, 'Joachim Low', '1986/12/12', 1, '027699843', 0906798223,'low@gmail.com','Germany'); 
        
insert into service(service_id, service_name, service_area, service_max_people, service_cost, rent_type_id, service_type_id, 
standard_room, description_other_convenience, pool_area, number_of_floors)
values  ('DV-1111', "Villa 1",100,5,1000,1,1,'Luxury','Balcony', 40, 3),
		('DV-2222', "House 1",60,4,600,2,2,'Suite','Bathtub', null, 2),
		('DV-3333', "Room 1",40,3,300,3,3, null, null, null, null),
		('DV-4444', "Villa 2",80,5,800,4,1,'Luxury','Balcony', 40, 3),
		('DV-5555', "Room 2",30,2,200,2,3, null, null, null, null),
        ('DV-6666', "House 2",50,4,600,2,2,'Suite','Bathtub', null, 2);
        
insert into contract(employee_id, customer_id, service_id, contract_start_date, contract_end_date, contract_deposit, contract_total)
values 	(1,'KH-2222','DV-1111',"2018-12-12","2019-03-12",100,0),
		(1,'KH-1111','DV-5555',"2019-01-12","2019-08-12",100,0),
		(2,'KH-5555','DV-4444',"2020-01-12","2020-10-12",100,0),
		(5,'KH-6666','DV-6666',"2021-01-12","2020-10-12",100,0),
		(4,'KH-3333','DV-3333',"2019-05-01","2021-05-01",100,0),
        (6,'KH-2222','DV-2222',"2016-12-12","2019-03-12",100,0),
        (3,'KH-4444','DV-3333',"2019-10-27","2019-11-12",300,0),
		(6,'KH-3333','DV-2222',"2019-12-24","2019-12-28",200,0);
        
insert into contract_detail(contract_id, attach_service_id, quantity)
values 	(1,1,3),
		(2,3,3),
		(2,4,5),
        (6,3,2),
		(7,4,4),
        (6,3,1),
        (3,3,8),
		(4,4,9),
        (5,2,1),
        (8,5,1);