DROP TABLE users;

DROP TABLE accounts;

CREATE TABLE users (
id int primary key,
email text,
name text
);

INSERT INTO users VALUES (1, 'email_1@mail.ru', 'first_name');
INSERT INTO users VALUES (2, 'email_2@bk.ru', 'second_name');

CREATE TABLE accounts(
 id int primary key,
 login text,
 password text,
 user_id int references users(id)
);

INSERT INTO accounts VALUES (1, 'login_1', '12345', 1);
INSERT INTO accounts VALUES (2, 'login_2', '67890', 2);

CREATE TABLE payment (
id int primary key,
amount decimal,
payment_date date,
account_id int references accounts(id)
);

INSERT INTO payment VALUES (1, 100.0, '2022-09-09', 1);
INSERT INTO payment VALUES (2, 200.0, '2022-08-08', 2);

SELECT u.id, u.email, u.name, a.login, a.password, p.amount, p.payment_date
FROM users AS u
JOIN accounts AS a ON u.id = a.user_id
JOIN payment AS p ON a.id = p.account_id;