show databases;

create database employeemanagementsystem;

use employeemanagementsystem;

create table login(
username varchar(30), 
password varchar(30)
);

desc login;

insert into login values('admin', 'admin');

select * from login;

show tables;

create table employee(
name varchar(30), 
fname varchar(30), 
dob varchar(30), 
salary varchar(10), 
address varchar(100), 
phone varchar(20), 
email varchar(40), 
education varchar(30), 
designation varchar(30), 
aadhar varchar(15), 
empid varchar(10)
);

desc employee;

-- insert into employee values ('a', 'b','Mar 6, 2024','2','asd','2','adf','BBA','Board of Directors or Owners','2132','783984');
select * from employee;

-- truncate table employee;
