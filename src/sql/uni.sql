create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('Samsung', 20000), ('iPhone', 100000), ('Huawei', 18000), ('Xaomi', 15000), ('Honor', 17000);
insert into people(name) values ('Andrew'), ('Vitalyi'), ('Sergey'), ('Alex'), ('Nataliya');

insert into devices_people(device_id, people_id) values (1, 1), (1, 3), (1, 5);
insert into devices_people(device_id, people_id) values (2, 1), (2, 5);
insert into devices_people(device_id, people_id) values (3, 2), (3, 4);
insert into devices_people(device_id, people_id) values (4, 1), (4, 2), (4, 3), (4, 4), (4, 5);
insert into devices_people(device_id, people_id) values (5, 3);

select avg(price) from devices;



