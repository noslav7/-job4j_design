CREATE TABLE account (
    id int not null primary key,
    name text
);

INSERT INTO account VALUES (1, 'Petr Arsentev');
INSERT INTO account VALUES (2, 'Ivan Ivanov');
INSERT INTO account VALUES (3, 'Gleb Bobrov');

select id, name from account
where id = 1