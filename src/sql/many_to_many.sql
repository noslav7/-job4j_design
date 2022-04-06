create table tutors(
	id serial primary key,
	name varchar (255)
);

create table modules (
	id serial primary key,
	name varchar (255)
);

create table tutors_modules (
	id serial primary key,
	tutors_id int references tutors(id),
	modules_id int references modules(id)
);

insert into tutors(name) values ('Orekhova S.V.')

insert into tutors(name) values ('Shitikov S.A.')

insert into tutors(name) values ('Kopnov V.A.')

insert into modules(name) values('Economics')

insert into modules(name) values('Mathematics')

insert into modules(name) values('Quality_management')

insert into tutors_modules(tutors_id, modules_id) values (1, 1)

insert into tutors_modules(tutors_id, modules_id) values (1, 2)

insert into tutors_modules(tutors_id, modules_id) values (1, 3)

insert into tutors_modules(tutors_id, modules_id) values (2, 1)

insert into tutors_modules(tutors_id, modules_id) values (2, 2)

insert into tutors_modules(tutors_id, modules_id) values (3, 3)

