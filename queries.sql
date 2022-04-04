create table junior (
    id serial primary key,
	name varchar (255),
	duration integer,
    topic text
);

insert into junior(name, duration, topic) values('Valentin', 5, 'java_core');

select * from junior;

update junior set name = 'andrew';

select * from junior;

delete from junior;

select * from junior;