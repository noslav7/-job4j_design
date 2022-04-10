create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
	expired_date DATE,
    price int,
	type_id int references type(id)
);

insert into type(name) values ('ФРУКТ');
insert into type(name) values ('ОВОЩ');
insert into type(name) values ('МЯСО');
insert into type(name) values ('СЫР');

insert into product(name, expired_date, price, type_id) values ('Яблоки', '2022-05-15', 150, 1);
insert into product(name, expired_date, price, type_id) values ('Груши', '2022-04-30', 200, 1);
insert into product(name, expired_date, price, type_id) values ('Помидор', '2022-04-25', 170, 2);
insert into product(name, expired_date, price, type_id) values ('Огурцы', '2022-05-15', 120, 2);
insert into product(name, expired_date, price, type_id) values ('Говядина', '2022-04-15', 350, 3);
insert into product(name, expired_date, price, type_id) values ('Свинина', '2022-04-15', 370, 3);
insert into product(name, expired_date, price, type_id) values ('Голландский', '2022-05-15', 650, 4);
insert into product(name, expired_date, price, type_id) values ('Российский', '2022-05-15', 500, 4);

select name from product where type_id = 4;

select name from product where name like '%мороженое%';

select name from product where expired_date < now();

select max(price) from product;

select name from product where price = 650;

SELECT COUNT(*)
FROM product
WHERE type_id = 1;

SELECT COUNT(*)
FROM product
WHERE type_id = 2;

SELECT COUNT(*)
FROM product
WHERE type_id = 3;

SELECT COUNT(*)
FROM product
WHERE type_id = 4;

select name from product where type_id = 4;