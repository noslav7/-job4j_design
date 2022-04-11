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

SELECT p.name
FROM product as p
JOIN type as t
ON p.type_id = t.id
WHERE t.name = 'СЫР';

select name from product where name like '%мороженое%';

select name from product where expired_date < now();

select name from product where price = (select max(price) from product);

SELECT
t.name,
COUNT(p.name)
FROM product AS p
JOIN type AS t
ON p.type_id = t.id
GROUP BY t.name;

SELECT
p.name
FROM product AS p
JOIN type AS t
ON p.type_id = t.id
WHERE t.name = 'СЫР'
OR t.name = 'МОЛОКО';

SELECT
t.name,
COUNT(p.name)
FROM product AS p
JOIN type AS t
ON p.type_id = t.id
GROUP BY t.name
HAVING COUNT(p.name) < 10;

select p.name, t.name
from product as p
join type as t
on p.type_id = t.id;