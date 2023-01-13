begin transaction;

insert into products (name, producer, count, price) VALUES ('product_6', 'producer_6', 30, 75);

savepoint first_savepoint;

insert into products (name, producer, count, price) VALUES ('product_7', 'producer_7', 10, 100);

savepoint second_savepoint;

insert into products (name, producer, count, price) VALUES ('product_8', 'producer_8', 12, 61);

savepoint third_savepoint;

insert into products (name, producer, count, price) VALUES ('product_9', 'producer_9', 17, 43);

select * from products;

rollback to second_savepoint;

select * from products;

rollback to first_savepoint;

select * from products;

commit;

select * from products;