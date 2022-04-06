create table tutors(
	id serial primary key,
	spn varchar (255)
);

create table modules(
	id serial primary key,
	subject varchar (255)
);

create table tutors_modules (
	id serial primary key,
	tutors_id int references tutors(id),
	modules_id int references modules(id)
);

insert into tutors(spn) values ('Orekhova S.V.')

insert into tutors(spn) values ('Shitikov S.A.')

insert into tutors(spn) values ('Kopnov V.A.')

insert into modules(subject) values('Economics')

insert into modules(subject) values('Mathematics')

insert into modules(subject) values('Quality_management')

insert into tutors_modules(tutors_id, modules_id) values (1, 1)

insert into tutors_modules(tutors_id, modules_id) values (1, 2)

insert into tutors_modules(tutors_id, modules_id) values (1, 3)

insert into tutors_modules(tutors_id, modules_id) values (2, 1)

insert into tutors_modules(tutors_id, modules_id) values (2, 2)

insert into tutors_modules(tutors_id, modules_id) values (3, 3)

