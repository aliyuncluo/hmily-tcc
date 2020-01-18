create database tcc character set 'utf8'

create table hmily_order(
id  int(10) primary key auto_increment,
order_no  varchar(50),
product_name varchar(255),
product_num  int(10),
unit_price decimal(10,2),
total   decimal(10,2)
);

create table hmily_account(
 id int(10) primary key auto_increment,
 acct_no varchar(50),
 acct_name varchar(255),
 acct_bal decimal(10,2),
 fronze decimal(10,2),
 update_time datetime,
 deleted int(2)
)
insert into hmily_account (acct_no,acct_name,acct_bal,update_time,deleted) values ('P0001','lisi',10000,now(),0);