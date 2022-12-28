create table products (
id serial primary key,
name varchar(50),
producer varchar(50),
count integer default 0,
price integer
);

create or replace function plus_tax_on_unit()
returns trigger as
$$
BEGIN
update products
set price = price + price * 0.2;
return new;
END;
$$
LANGUAGE 'plpgsql';

create trigger tax_on_unit_trigger
    after insert on products
    for each statement
execute procedure plus_tax_on_unit();

create or replace function tax_on_unit_before_insert()
    returns trigger as
$$
BEGIN
    update products
    set price = price + price * 0.2;
    return NEW;
END;
$$
    LANGUAGE 'plpgsql';

create trigger tax_on_unit_before_insert_trigger
    before insert on products
    for each row
execute procedure tax_on_unit_before_insert();

create table history_of_price (
id serial primary key,
name varchar(50),
price integer,
date timestamp
);

