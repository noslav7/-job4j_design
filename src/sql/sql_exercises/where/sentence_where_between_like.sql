CREATE TABLE customers(
id int not null primary key,
first_name text,
last_name text,
active boolean,
email text
);

INSERT INTO customers VALUES(1, 'Ann', 'Furs', true, 'ann@bk.ru');
INSERT INTO customers VALUES(2, 'Andrey', 'Hincu', false, 'anincu@bk.ru');
INSERT INTO customers VALUES(3, 'Anne', 'Dow', true, 'anne@bk.ru');
INSERT INTO customers VALUES(4, 'Elena', 'Kartashova', false, 'ekart@bk.ru');
INSERT INTO customers VALUES(5, 'Annie', 'Sergeeva', true, 'annie@bk.ru');
INSERT INTO customers VALUES(6, 'Lana', 'Sergeeva', true, 'lserg@bk.ru');

SELECT id, first_name, last_name, active, email
FROM customers
WHERE first_name LIKE 'An%'
AND LENGTH(first_name) BETWEEN 3 AND 5