CREATE TABLE movies(
    id int not null primary key,
    name text,
    producer text,
    category_id int
);

INSERT INTO movies VALUES(1, 'name_1', 'producer_1', 1);
INSERT INTO movies VALUES(2, 'name_2', 'producer_2', 2);
INSERT INTO movies VALUES(3, 'name_3', 'producer_3', 3);
INSERT INTO movies VALUES(4, 'name_4', 'producer_4', 4);
INSERT INTO movies VALUES(5, 'name_5', 'producer_3', 1);
INSERT INTO movies VALUES(6, 'name_6', 'producer_2', 2);
INSERT INTO movies VALUES(7, 'name_7', 'producer_4', 3);
INSERT INTO movies VALUES(8, 'name_8', 'producer_1', 1);
INSERT INTO movies VALUES(9, 'name_9', 'producer_3', 2);
INSERT INTO movies VALUES(10, 'name_10', 'producer_1', 1);

SELECT category_id, COUNT(category_id)
FROM movies
GROUP BY category_id