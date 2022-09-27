SELECT c.id, c.model, e.volume, e.power
FROM cars AS c
INNER JOIN engines AS e ON c.id = car_id;