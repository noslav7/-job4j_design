create table subjects(
    id serial primary key,
    theme varchar(255)
);

create table lecturers(
    id serial primary key,
    spn varchar(255),
    position_id int references subjects(id)
);

insert into subjects(theme) values ('macroeconomics');

insert into lecturers(spn, position_id) values ('Belkov A.A.', 1);

insert into lecturers(spn, position_id) values ('Zotov E.I.', 1);

insert into lecturers(spn, position_id) values ('Nazarov I.V.', 1);

select * from lecturers where id in (select id from subjects);