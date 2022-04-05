create table device(
    id serial primary key,
    seria int,
    number int
);

create table password(
    id serial primary key,
    name varchar(255),
    device_id int references device(id) unique
);

insert into device(seria, number) values (1, 15)

insert into device(seria, number) values (2, 18)

insert into device(seria, number) values (1, 30)

insert into password(name) values ('super')

insert into password(name) values ('pass')

insert into password(name) values ('word')