CREATE TABLE subjects(
id int not null primary key,
name text,
grade int,
start_date timestamp
);

INSERT INTO subjects VALUES(1, 'Math', 50, current_date);
INSERT INTO subjects VALUES(2, 'English', 75, current_date);
INSERT INTO subjects VALUES(3, 'Sociology', 65, current_date);
INSERT INTO subjects VALUES(4, 'Economics', 60, current_date);
INSERT INTO subjects VALUES(5, 'Computer Science', 70, current_date);

SELECT id, first_name, last_name, active, email
FROM customers
WHERE first_name LIKE 'An%'
AND LENGTH(first_name) BETWEEN 3 AND 5