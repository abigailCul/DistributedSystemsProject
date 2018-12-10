DROP DATABASE booking_system;
CREATE DATABASE booking_system;
USE booking_system;



drop table if exists Cars;
create table Cars (
   rental_id int,
   car_make varchar(50),
   car_model varchar(50),
   primary key (rental_id)
);

drop table if exists Accounts;
create table Accounts (
    acc_no int,
    first_name varchar(50),
    surname varchar(50),
    primary key(acc_no)
);

drop table if exists Booking
create table Booking (
    id int NOT NULL AUTO_INCREMENT,
    rental_id int,
    acc_no int,
    rental_date Date,
    return_date Date,
    primary key(id),
    foreign key(acc_no) references Accounts(acc_no),
    foreign key(rental_id) references Cars(rental_id)
);

insert into cars values(101,'Ford', 'Focus');
insert into cars values(102,'BMW', '3-series');
insert into cars values(103,'Ford', 'Galaxy');
insert into accounts values(1010, 'Peter', 'Burke');
insert into accounts values(1020, 'Meghan', 'Smith');
insert into booking values(45, 105, 1010, '2018-12-04','2018-12-30');