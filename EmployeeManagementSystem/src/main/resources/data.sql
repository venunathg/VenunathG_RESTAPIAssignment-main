--admin admin123
--user user123

insert into users (user_id,password, username) values (1,'$2a$12$ODjUpuyTc2xbJomLP.sz4eHuXO0x8ysR7qFgSWhIS9OSQo9YDQIiu', 'admin');
insert into users (user_id,password, username) values (2,'$2a$12$ExxZxINC0/NdOpzg3Wu9IeVV6uC5mTwObgL7IqRGyhjUGRNnkdtgS', 'user');

insert into roles (role_id,name) values(1,'ADMIN');
insert into roles (role_id,name) values(2,'USER');

insert into users_roles (user_id, role_id) values (1, 1);
insert into users_roles (user_id, role_id) values (2, 2);

insert into employee (id, first_name, last_name, email) values (1, 'Venunath', 'Gondipatla', 'venunathgondipatla@gmail.com');
insert into employee (id, first_name, last_name, email) values (2, 'venu', 'nath', 'venunath@gmail.com');
insert into employee (id, first_name, last_name, email) values (3, 'gvn', 'gl', 'gvnlearning@gmail.com');
