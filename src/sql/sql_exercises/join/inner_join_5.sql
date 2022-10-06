CREATE TABLE cars (
id int primary key,
model text
);

CREATE TABLE engines (
id int primary key,
volume decimal,
power int,
car_id int references cars(id)
);

INSERT INTO cars VALUES (1, 'Toyota Camry');
INSERT INTO cars VALUES (2, 'Renault Sandero');

INSERT INTO engines VALUES (1, 2.5, 181, 1);
INSERT INTO engines VALUES (2, 1.2, 75, 2);

SELECT c.id, c.model, e.volume, e.power
FROM cars AS c
INNER JOIN engines AS e ON c.id = car_id;