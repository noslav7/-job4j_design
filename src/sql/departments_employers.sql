create table departments(
    id serial primary key,
    name varchar(255)
);

create table employees(
    id serial primary key,
    name varchar(255),
    department_id int references departments(id)
);

insert into departments(name) values ('IT-department');
insert into departments(name) values ('Production');
insert into departments(name) values ('Accountancy');

insert into employees(name, department_id) values ('Andrew', 1);
insert into employees(name, department_id) values ('Michael', 1);
insert into employees(name, department_id) values ('Dmitriy', 1);
insert into employees(name, department_id) values ('Olga', 3);
insert into employees(name, department_id) values ('Tatiyana', 3);
insert into employees(name, department_id) values ('Nataliya', 3);

select *
from employees e
left join departments d
on e.department_id = d.id;

select *
from departments d
right join employees e
on e.department_id = d.id;

select *
from employees e
full join departments d
on e.department_id = d.id;

select *
from employees e
cross join departments d;

select d.name
from departments d
left join employees e
on e.department_id = d.id
where e.name is null;

select *
from employees e
left join departments d
on e.department_id = d.id;

select *
from employees e
right join departments d
on e.department_id = d.id
where e.name is not null;;

create table teens(
    id serial primary key,
    name varchar(255),
	gender varchar(255)
);

insert into teens(name, gender) values ('Andrew', 'male');
insert into teens(name, gender) values ('Michael', 'male');
insert into teens(name, gender) values ('Dmitriy', 'male');
insert into teens(name, gender) values ('Sergey', 'male');
insert into teens(name, gender) values ('Vladimir', 'male');
insert into teens(name, gender) values ('Olga', 'female');
insert into teens(name, gender) values ('Tatiyana', 'female');
insert into teens(name, gender) values ('Nataliya', 'female');
insert into teens(name, gender) values ('Nadezhda', 'female');
insert into teens(name, gender) values ('Elena', 'female');

SELECT name, gender
INTO teens2
FROM teens
WHERE gender = 'male';

SELECT name, gender
INTO teens3
FROM teens
WHERE gender = 'female';

SELECT teens2.name, teens3.name
FROM teens2
CROSS JOIN teens3;