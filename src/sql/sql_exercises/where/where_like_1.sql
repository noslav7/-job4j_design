CREATE TABLE airplanes(
id int not null primary key,
model text,
range int,
capacity int
);

INSERT INTO airplanes VALUES(1, 'Airbus-320-200', 5700, 180);
INSERT INTO airplanes VALUES(2, 'Airbus-321-200', 5600, 220);
INSERT INTO airplanes VALUES(3, 'Airbus-319-100', 6700, 150);
INSERT INTO airplanes VALUES(4, 'Cessna 208 Caravan', 1200, 13);
INSERT INTO airplanes VALUES(5, 'Boeing 777-300', 11100, 450);
INSERT INTO airplanes VALUES(6, 'Boeing 767-300', 7900, 350);
INSERT INTO airplanes VALUES(7, 'Boeing 737-300', 4200, 145);
INSERT INTO airplanes VALUES(8, 'Sukhoi SuperJet-100', 3000, 98);
INSERT INTO airplanes VALUES(9, 'Bombardier CRJ-200', 2700, 50);

SELECT id, model, range, capacity FROM airplanes WHERE model LIKE 'Airbus%';