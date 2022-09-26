CREATE TABLE cars (
id int primary key,
model text
);

CREATE TABLE engines (
number int primary key,
volume decimal,
power int,
car_id int references cars(id)
);

INSERT INTO cars VALUES (1, 'Toyota Camry');
INSERT INTO cars VALUES (2, 'Renault Sandero');

INSERT INTO engines VALUES (1234, 2.5, 181, 1);
INSERT INTO engines VALUES (5678, 1.2, 75, 2);

SELECT id, model, volume, power
FROM cars
INNER JOIN engines ON id = car_id;