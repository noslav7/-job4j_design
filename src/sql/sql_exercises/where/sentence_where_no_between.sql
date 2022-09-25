INSERT INTO subjects VALUES(1, 'Math', 50, current_date);
INSERT INTO subjects VALUES(2, 'English', 75, current_date);
INSERT INTO subjects VALUES(3, 'Sociology', 65, current_date);
INSERT INTO subjects VALUES(4, 'Economics', 60, current_date);
INSERT INTO subjects VALUES(5, 'Computer Science', 70, current_date);

SELECT id, name, grade, start_date
FROM subjects
WHERE grade >= 65 AND grade <= 80;