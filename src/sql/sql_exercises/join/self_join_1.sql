CREATE TABLE employees (
e_id int primary key,
name text,
superviser_id int references employees(e_id)
);

INSERT INTO employees VALUES (1, 'Petr', null),
                             (2, 'Andrey', 1),
                             (3, 'Elena', 1),
                             (4, 'Anna', 2),
                             (5, 'Stas', 2),
                             (6, 'Sergey', 3),
                             (7, 'Alex', 3),
                             (8, 'Michael', 3);

SELECT e.name, m.name
FROM employees AS m
INNER JOIN employees AS e ON m.e_id = e.superviser_id;