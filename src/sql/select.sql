create table fauna(
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values ('Sabretooth_Tiger', 10950, date '01.01.1850');
insert into fauna(name, avg_age, discovery_date)
values ('Mammoth', 18250, date '01.01.1825');
insert into fauna(name, avg_age, discovery_date)
values ('Ihtiozaurus', 18250, date '01.01.1910');
insert into fauna(name, avg_age, discovery_date)
values ('Swordfish', 10950, date '01.01.1800');
insert into fauna(name, avg_age, discovery_date)
values ('Python', 21900, date '01.01.1760');
insert into fauna(name, avg_age, discovery_date)
values ('Frog', 3650, date '01.01.1753');
insert into fauna(name, avg_age, discovery_date)
values ('Cat', 5475, date '01.01.1753');
insert into fauna(name, avg_age, discovery_date)
values ('Dog', 5475, date '01.01.1753');
insert into fauna(name, avg_age, discovery_date)
values ('Cow', 7300, date '01.01.1755');
insert into fauna(name, avg_age, discovery_date)
values ('Goat', 5475, date '01.01.1775');

select * from fauna where name like '%fish%';

select * from fauna where avg_age > 10000 and avg_age < 21000;

select * from fauna where discovery_date is null;

select * from fauna where discovery_date < '01.01.1950';

