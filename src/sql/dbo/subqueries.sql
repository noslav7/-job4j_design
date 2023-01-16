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