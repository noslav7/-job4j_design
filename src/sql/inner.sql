create table address(
    id serial primary key,
    street varchar(255),
    house int
);

create table citizens(
    id serial primary key,
    name varchar(255),
    address_id int references address(id)
);

insert into address(street, house) values ('Soyuznaya', 8);
insert into address(street, house) values ('Surikova', 57);
insert into address(street, house) values ('Serova', 34);

insert into citizens(name, address_id) values ('Andrew', 1);
insert into citizens(name, address_id) values ('Nataliya', 2);
insert into citizens(name, address_id) values ('Vasya', 3);
insert into citizens(name) values ('Vitaliy');
insert into citizens(name) values ('Irina');

select cz.name, ad.street, ad.house
from citizens as cz
join address as ad
on cz.address_id = ad.id
where street = 'Soyuznaya';

select cz.name, ad.street, ad.house
from citizens as cz
join address as ad
on cz.address_id = ad.id
where street = 'Serova';

select cz.name, ad.street, ad.house
from citizens as cz
join address as ad
on cz.address_id = ad.id
where house = 57;
