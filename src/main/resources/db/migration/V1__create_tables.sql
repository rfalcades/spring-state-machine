create table orders (
    id int auto_increment primary key not null,
    status varchar(30) not null,
    total decimal(10,2) not null,
    created_date timestamp not null
);



insert into orders (status, total, created_date) values ('CREATED', 100.00, '2024-08-21 00:00:00');
insert into orders (status, total, created_date) values ('CREATED', 200.00, '2024-08-22 00:00:00');
insert into orders (status, total, created_date) values ('CREATED', 300.00, '2024-08-23 00:00:00');
