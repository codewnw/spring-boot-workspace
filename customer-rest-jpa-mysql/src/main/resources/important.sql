create database customer_db;
create user 'customer'@'%' identified by 'customer';
grant all on customer_db.* to 'customer'@'%';