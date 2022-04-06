insert into users(customer) values ('Кротов');
insert into users(customer) values ('Сергеев');
insert into users(customer) values ('Патимов');

insert into role(role, users_id) VALUES ('актер', 1);
insert into role(role, users_id) VALUES ('режиссер', 2);
insert into role(role, users_id) VALUES ('сценарист', 3);

insert into rules(requirement) values ('артистизм');
insert into rules(requirement) values ('интеллектуальность');
insert into rules(requirement) values ('креативность');

insert into role_rules(role_id, rules_id) values (1, 1);
insert into role_rules(role_id, rules_id) values (2, 2);
insert into role_rules(role_id, rules_id) values (3, 3);

insert into item(object, users_id) VALUES ('Костюм', 1);
insert into item(object, users_id) VALUES ('Камера', 2);
insert into item(object, users_id) VALUES ('Сценарий', 3);

insert into comments(statement, item_id) VALUES ('Красивый', 1);
insert into comments(statement, item_id) VALUES ('Новая', 2);
insert into comments(statement, item_id) VALUES ('Оригинальный', 3);

insert into attachs(attachment, item_id) VALUES ('Текст_речи', 1);
insert into attachs(attachment, item_id) VALUES ('Кинопленка', 2);
insert into attachs(attachment, item_id) VALUES ('Сюжет', 3);

insert into category(class) values ('perfect');
insert into category(class) values ('good');
insert into category(class) values ('moderate');

insert into state(characteristic) values ('new');
insert into state(characteristic) values ('good');
insert into state(characteristic) values ('outdated');

update item
set category_id = '2', state_id = '1'
where id = 1;

update item
set category_id = '1', state_id = '3'
where id = 2;

update item
set category_id = '2', state_id = '2'
where id = 3;