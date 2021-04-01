--  create schema assignment 12
create schema assignment12;

-- create table pizzas
create table if not exists assignment12.pizzas(
    pizzaID int not null primary key auto_increment,
    pizzaName varchar(255) not null,
    pizzaPrice decimal not null
);

-- create table customers
create table if not exists assignment12.customers(
    customerID int not null primary key auto_increment,
    customerName varchar(255) not null,
    customerSurname varchar(255),
    customerPhoneNumber varchar(255) not null
);

-- create table orders
create table if not exists assignment12.orders(
    orderID int not null primary key auto_increment,
    quantity int not null,
    customerID int not null,
    foreign key (customerID) references customers(customerID),
    pizzaID int not null,
    foreign key (pizzaID) references pizzas(pizzaID),
    dateTimeOrder datetime not null
);

-- populate customers table
insert into customers(customerName, customerSurname, customerPhoneNumber)
values
('trevor', 'page', '555-000'),
('john', 'doe', '123-000');

-- populate pizzas table
insert into pizzas(pizzaName, pizzaPrice)
values
('Pepperoni & Cheese', 7.99),
('Vegetarian', 9.99),
('Meat Lovers', 14.99),
('Hawaiian', 12.99);

-- order #1
insert into orders(quantity, customerID, pizzaID, dateTimeOrder)
values(1, 1, 1, '9-10-2014 9:47:00'),
      (1, 1, 3, '9-10-2014 9:47:00');

-- order # 2
insert into orders(quantity, customerID, pizzaID, dateTimeOrder)
values(1, 2, 1, '9-10-2014 9:47:00'),
      (2, 2, 3, '9-10-2014 9:47:00');

-- order #3
insert into orders(quantity, customerID, pizzaID, dateTimeOrder)
values(1, 1, 3, '2014-10-9 9:47:00'),
      (1, 1, 4, '2014-10-9 9:47:00');

-- Q #4
select sum(pizzaPrice), customerName, customerSurname
from pizzas
         join orders o on pizzas.pizzaID = o.pizzaID
         join customers c on c.customerID = o.customerID
group by customerName, customerSurname
