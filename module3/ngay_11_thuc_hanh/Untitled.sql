create database demo;


use demo;
create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name nvarchar(120) NOT NULL,	
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
insert into users(name, email, country) values('Beckham','beckham@real.esp','England');
insert into users(name, email, country) values('Rosicky','rosicky@ars.uk','Czech');
insert into users(name, email, country) values('Arteta','arteta@ars.uk','Spain');

use demo;
DELIMITER //
create procedure getUserByCountry (
in user_country varchar(120), 
out user_name varchar(120))
begin 
select name into user_name from users
where country = user_country;
end; //
DELIMITER ;

DELIMITER //
create procedure sortByName()
begin
select * from users
order by name desc;
end; //
DELIMITER ;

call sortByName();

DELIMITER $$

CREATE PROCEDURE get_user_by_id(IN user_id INT)

BEGIN

    SELECT users.name, users.email, users.country

    FROM users

    where users.id = user_id;

    END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE insert_user(

IN user_name varchar(120),

IN user_email varchar(220),

IN user_country varchar(120)

)

BEGIN

    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);

    END$$

DELIMITER ;





