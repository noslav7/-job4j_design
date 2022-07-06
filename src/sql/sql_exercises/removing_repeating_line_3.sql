INSERT INTO subjects VALUES(1, 'Math', 75, current_date);
INSERT INTO subjects VALUES(2, 'Math', null, current_date);
INSERT INTO subjects VALUES(3, 'Math', 75, current_date);
INSERT INTO subjects VALUES(4, 'Math', 85, current_date);
INSERT INTO subjects VALUES(5, 'Math', null, current_date);

SELECT DISTINCT name, grade
FROM products