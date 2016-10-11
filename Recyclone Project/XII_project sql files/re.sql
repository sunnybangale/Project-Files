create database record;
use record;
create table Employee2(
Empno integer not null primary key,
Salary double);
insert into Employee2 values(100 , 200.85);
insert into Employee2 values(200 , 129.54);
insert into Employee2 values(300 , 98.17);

create table Employer(
Id integer,
Employee_No integer,
 foreign key(Employee_No) references Employee2(Empno) on delete cascade);
insert into Employer values(51 , 100);
insert into Employer values(52 , 100);
insert into Employer values(53 , 200);
insert into Employer values(54 , 300);
