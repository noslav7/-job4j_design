DROP TABLE engines;

DROP TABLE cars;

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
INSERT INTO cars VALUES (2, 'Kia Rio');
INSERT INTO cars VALUES (3, 'Audi A6');
INSERT INTO cars VALUES (4, 'Renault Sandero');

INSERT INTO engines VALUES (1234, 2.5, 181, 1);
INSERT INTO engines VALUES (1479, 1.6, 123, null);
INSERT INTO engines VALUES (5678, 1.2, 75, 4);
INSERT INTO engines VALUES (5072, 3.0, 231, null);

SELECT *
FROM cars
FULL OUTER JOIN engines on cars.id = engines.car_id;