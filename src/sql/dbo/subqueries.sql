CREATE TABLE customers(
id serial primary key,
first_name text,
last_name text,
age int,
country text
);

INSERT INTO customers VALUES(1, 'Manuel', 'Neuer', 36, 'Germany'),
                      (2, 'Virgil', 'van Dijk', 32, 'Netherlands'),
                      (3, 'Luca', 'Modric', 38, 'Croatia'),
                      (4, 'Sadyo', 'Mane', 30, 'Senegal'),
                      (5, 'Lonel', 'Messi', 35, 'Argentina');

select first_name, last_name from customers
where age = (select min(age) from customers);

CREATE TABLE orders(
id serial primary key,
amount int,
customer_id int references customers(id)
);

INSERT INTO orders VALUES(1, 5, 1),
                         (2, 4, 2),
                         (3, 3, 3),
                         (4, 4, 4);

select first_name, last_name from customers
where id NOT IN (select customer_id from orders);