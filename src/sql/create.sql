create table users(
    id serial primary key,
    customer text,
    role_id int references role(id)
);

create table role (
    id serial primary key,
    role text
);

create table rules(
     id serial primary key,
     requirement text
);

create table role_rules(
     id serial primary key,
     role_id int references role(id),
     rules_id int references rules(id)
);

create table item(
    id serial primary key,
    object varchar(255),
    users_id int references users(id),
    category_id int references category(id),
    state_id int references state(id)
);

create table comments(
    id serial primary key,
    statement text,
    item_id int references item(id)
);

create table attachs(
    id serial primary key,
    attachment text,
    item_id int references item(id)
);

create table category(
     id serial primary key,
     class varchar(255)
);

create table state(
    id serial primary key,
    characteristic varchar(255)
);

alter table item
add  category_id int references category(id);

alter table item
add state_id int references state(id);

