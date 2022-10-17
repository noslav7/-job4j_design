DROP TABLE actions;

DROP TABLE colors;

CREATE TABLE colors (
color_id int primary key,
name text
);

CREATE TABLE actions (
number int primary key,
description text,
color_id int references colors(color_id)
);

INSERT INTO colors VALUES(1, 'red');
INSERT INTO colors VALUES(2, 'white');
INSERT INTO colors VALUES(3, 'black');
INSERT INTO colors VALUES(4, 'purple');

INSERT INTO actions VALUES (1, 'draw red', 1);
INSERT INTO actions VALUES (2, 'pink panther', null);
INSERT INTO actions VALUES (3, 'use for painting', null);
INSERT INTO actions VALUES (4, 'use black hole', 2);

SELECT *
FROM colors
NATURAL JOIN actions;