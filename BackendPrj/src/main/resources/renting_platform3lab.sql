-- Create Database
create database if not exists renting_platform;

-- Use current Database
use renting_platform;

-- Drop Tables
drop table if exists dwelling_photo;
drop table if exists dwelling;
drop table if exists adress;
drop table if exists city;
drop table if exists region;
drop table if exists cash_withdrawal_from_service_to_owner;
drop table if exists cash_withdrawal_from_lessee_to_service;
drop table if exists reservation;
drop table if exists lessee_feedback;
drop table if exists lessee;
drop table if exists owner_feedback;
drop table if exists dwelling_owner;
drop table if exists platform_user;

-- Create Tables 
-- Adress Table
create table adress (
	id int not null auto_increment,
    street varchar(50) not null,
    house_number int null,
    city_id int not null,
    constraint PK_Adress primary key (id)
);

-- City Table
create table city (
	id int not null auto_increment,
    name varchar(35) not null,
    population int not null,
    region_id int not null,
    constraint PK_City primary key (id)
);

-- Region Table
create table region (
	id int not null auto_increment,
    name varchar(50) not null,
    constraint PK_Region primary key (id)
);

-- Dwelling Table
create table dwelling (
	id int not null auto_increment,
    area int not null,
    floor int not null,
    rooms_number int not null,
    description varchar(100) not null,
    adress_id int not null,
    dwelling_owner_id int not null,
    reservation_id int not null,
    constraint PK_Dwelling primary key (id)
);

-- Dwelling_photo Table
create table dwelling_photo (
	id int not null auto_increment,
    name varchar(50) null,
    dwelling_id int not null,
    constraint PK_Dwelling_photo primary key (id)
);

-- Reservation Table
create table reservation (
	id int not null auto_increment,
    is_possible boolean not	null,
    name varchar(50) not null,
    time timestamp not null,
    how_long date not null,
    is_confirmed boolean not null,
    lessee_id int not null,
    constraint PK_Reservation primary key (id)
);

-- Cash_withdrawal_from_lessee_to_service Table
create table cash_withdrawal_from_lessee_to_service (
	id int not null auto_increment,
    price int not null,
    reservation_id int not null,
    constraint PK_Cash_withdrawal_from_lessee_to_service primary key (id)
);

-- Cash_withdrawal_from_service_to_owner Table
create table cash_withdrawal_from_service_to_owner (
	id int not null auto_increment,
    price int not null,
    cash_withdrawal_from_lessee_to_service_id int not null,
    constraint PK_Ccash_withdrawal_from_service_to_owner primary key (id)
);


-- Dwelling_owner Table
create table dwelling_owner (
	id int not null auto_increment,
    name varchar(35) not null,
    surname varchar(75) not null,
    platform_user_id int not null,
    constraint PK_Dwelling_owner primary key (id)
);

-- Owner_feedback Table
create table owner_feedback ( 
	id int not null auto_increment,
    rating int not null,
    response varchar(100) not null,
    dwelling_owner_id int not null,
    constraint PK_Owner_feedback primary key (id)
);

-- Platform_user Table
create table platform_user (
	id int not null auto_increment,
    email varchar(50) not null,
    phone varchar(12) not null,
    constraint PK_Platform_user primary key (id)
);

-- Lessee Table
create table lessee ( 
	id int not null auto_increment,
    name varchar(35) not null,
    surname varchar(75) not null,
    platform_user_id int not null,
    constraint PK_Lessee primary key (id)
);

-- Lessee_feedback Table
create table lessee_feedback ( 
	id int not null auto_increment,
    rating int not null,
    response varchar(100) not null,
    lessee_id int not null,
    constraint PK_Lessee_feedback primary key (id)
);

-- Alter Tables
alter table city add constraint FK_City_region foreign key (region_id)
    references region (id);
    
alter table adress add constraint FK_Adress_city foreign key (city_id)
	references city (id);
    
alter table dwelling add constraint FK_Dwelling_adress foreign key (adress_id)
	references adress (id);

alter table dwelling add constraint FK_Dwelling_reservation foreign key (reservation_id)
	references reservation (id);
    
alter table dwelling add constraint FK_Dwelling_dwelling_owner foreign key (dwelling_owner_id)
	references dwelling_owner (id);

alter table dwelling_photo add constraint FK_Dwelling_photo_dwelling foreign key (dwelling_id)
	references dwelling (id);
    
alter table reservation add constraint FK_Reservation_lessee foreign key (lessee_id)
	references lessee (id);
    
alter table lessee add constraint FK_Lessee_user foreign key (platform_user_id)
	references platform_user (id);
    
alter table dwelling_owner add constraint FK_Dwelling_owner_user foreign key (platform_user_id)
	references platform_user (id);
    
alter table lessee_feedback add constraint FK_lessee_feedback_lessee foreign key (lessee_id)
	references lessee (id);
    
alter table owner_feedback add constraint FK_owner_feedback_dwelling_owner foreign key (dwelling_owner_id)
	references dwelling_owner (id);
    
alter table cash_withdrawal_from_lessee_to_service add constraint FK_cash_reservation foreign key (reservation_id)
	references reservation (id);
    
alter table cash_withdrawal_from_service_to_owner add constraint FK_cash_owner_cash_lessee foreign key (cash_withdrawal_from_lessee_to_service_id)
	references cash_withdrawal_from_lessee_to_service (id);
    
-- Create Indexes
create index city_name_idx on city(name);
create index lessee_surname_idx on lessee(surname);
create index dwelling_rooms_number_idx on dwelling(rooms_number);

-- Insert values
-- Insert platform_user Table
insert into platform_user (email, phone) values 
('mk@gmail.com', '09711'),
('km@gmail.com', '06721'),
('nm@gmail.com', '09832'),
('nh@gmail.com', '06733'),
('gh@gmail.com', '09787'),
('lm@gmail.com', '09754'),
('qw@gmail.com', '09898'),
('df@gmail.com', '09373'),
('pm@gmail.com', '09736'),
('er@gmail.com', '06715');

-- Insert dwelling_owner Table
insert into dwelling_owner (name, surname, platform_user_id) values 
('Max', 'Pelyshko', '1'),
('Olya', 'Rybenchuk', '3'),
('Danylo', 'Kovalchuk', '4'),
('Bodya', 'Dragan', '6'),
('Anna', 'Chyr', '9');

-- Insert lessee Table
insert into lessee (name, surname, platform_user_id) values
('Nazar', 'Katinskiy', '2'),
('Oleg', 'Kvachan', '5'),
('Oleg', 'Dudiak', '7'),
('Nastya', 'Vovchyk', '8'),
('Max', 'Shuback', '10');

-- Insert owner_feedback Table
insert into owner_feedback (rating, response, dwelling_owner_id) values
('5', 'excelent', '1'),
('5', 'excelent', '1'),
('4', 'good', '2'),
('5', 'excelent', '2'),
('5', 'excelent', '2'),
('4', 'good', '3'),
('4', 'good', '3'),
('3', 'not very good', '3'),
('2', 'bad', '4'), 
('2', 'bad', '4'),
('4', 'good', '4'),
('3', 'not very good', '4'),
('4', 'good', '5'),
('2', 'bad', '5');

-- Insert lessee_feedback Table
insert into lessee_feedback (rating, response, lessee_id) values
('5', 'excellent', '1'),
('4', 'good', '1'),
('5', 'excelent', '1'),
('5', 'excelent', '1'),
('3', 'not very good', '2'),
('4', 'good', '2'),
('2', 'bad', '2'),
('3', 'not very good', '3'),
('4', 'good', '3'),
('4', 'good', '3'),
('5', 'excelent', '4'),
('5', 'excelent', '4'),
('3', 'not very good', '5'),
('3', 'not very good', '5'),
('4', 'good', '5');

-- Insert region Table
insert into region (name) values
('Lviv Oblast'),
('Kyiv Oblast'),
('Kharkiv Oblast'),
('Ternopil Oblast'),
('Dnipro Oblast'),
('Rivne Oblast');

-- Insert city Table
insert into city (name, population, region_id) values
('Lviv', '750000', '1'),
('Staryi Sambir', '6500', '1'),
('Kyiv', '3100000', '2'),
('Sambir', '23000', '1'),
('Irpin', '15000', '2'),
('Mlyniv', '28000', '6'),
('Izum', '70000', '3'),
('Dnipro', '1120000', '5'),
('Zbarazh', '38000', '4'),
('Ternopil', '230000', '4');

-- Insert adress Table
insert into adress (street, house_number, city_id) values 
('Hayova', '19', '2'),
('Stepana Banderu', '45', '1'),
('Stepana Banderu', '104', '1'),
('Svobodu', null, '3'),
('Sadova', '13', '7'),
('Azovska', '68', '7'),
('Ozerna', '5', '8'),
('Centralna', '128', '4'),
('Lvivska', '56', '10'),
('Korolya Danyla', '33', '9');

-- Insert reservation Table
insert into reservation (is_possible, name, time, how_long, is_confirmed, lessee_id) values
(true, 'Dudiak reserv', '2022-04-23 15:00:00.000', '2023-06-01', true, '3'),
(true, 'Shuback reserv', '2022-08-10 12:00:00.000', '2023-10-20', false, '5'),
(false, 'Vovchyk reserv', '2022-09-27 10:00:00.000', '2024-01-01', false, '4'),
(true, 'Vovchyk reserv2', '2022-09-26 14:00:00.00', '2022-11-28', true, '4'),
(true, 'Katinskiy reserv', '2022-05-10 10:00:00.000', '2023-01-01', false, '1'),
(false, 'Kvachan reserv', '2021-02-15 16:00:00.000', '2023-02-15', false, '2'),
(true, 'Kvachan reserv2', '2022-08-27 12:40:00.00', '2024-02-15', true, '2');

-- Insert dwelling Table
insert into dwelling (area, floor, rooms_number, description, adress_id, dwelling_owner_id, reservation_id) values
('100', '2', '2','all include', '2', '3', '5'),
('50', '1', '1', 'all include', '3', '2', '3'),
('75', '1', '2', 'all include', '6', '5', '6'),
('55', '4', '1', 'all include', '1', '1', '7'),
('45', '1', '1', 'all include', '9', '2', '5'),
('85', '3', '2', 'all include', '5', '5', '3'),
('45', '3', '1', 'all include', '10', '2', '5'),
('90', '2', '2', 'all include', '4', '4', '4'),
('110', '1', '3', 'all include', '7', '4', '2'),
('55', '4', '2', 'all include', '8', '2', '5');

-- Insert cash_withdrawal_from_lessee_to_service Table
insert into cash_withdrawal_from_lessee_to_service (price, reservation_id) values
('10000', '1'),
('5000', '1'),
('11000', '2'),
('8500', '3'),
('9000', '4'),
('4500', '5'),
('4500', '5'),
('5500', '5'),
('7500', '6'),
('5500', '7');

-- Insert cash_withdrawal_from_service_to_owner Table
insert into cash_withdrawal_from_service_to_owner (price, cash_withdrawal_from_lessee_to_service_id) values
('10000', '1'),
('5000', '2'),
('11000', '3'),
('8500', '4'),
('9000', '5'),
('4500', '6'),
('4500', '7'),
('5500', '8'),
('7500', '9'),
('5500', '10');

show index from city;
show index from lessee;
show index from dwelling;



