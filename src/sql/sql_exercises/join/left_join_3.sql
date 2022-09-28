DROP TABLE accounts CASCADE;

CREATE TABLE accounts (
id int primary key,
email text,
password text
);

DROP TABLE accounts CASCADE;

CREATE TABLE users (
id int primary key,
email text,
name text,
account_id int references accounts(id)
);

INSERT INTO accounts VALUES (1, 'some_for_auth_1@mail.ru', '1_3_5');
INSERT INTO accounts VALUES (2, 'some_for_auth_1@bk.ru', '6%8%0');
INSERT INTO accounts VALUES (3, 'for_auth_1@mail.ru', '12345');
INSERT INTO accounts VALUES (4, 'for_auth_1@bk.ru', '67890');

INSERT INTO users VALUES (1, 'email_1@mail.ru', 'first_name', 3);
INSERT INTO users VALUES (2, 'email_2@bk.ru', 'second_name', 4);

SELECT a.id, a.email, a.password, u.id, u.email, u.name
FROM accounts AS a
LEFT JOIN users AS u ON a.id = u.account_id;