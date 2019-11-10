drop DATABASE IF EXISTS `netbanking`;

CREATE DATABASE  IF NOT EXISTS `netbanking`;
USE `netbanking`;

drop table if exists `user`;

create table `user`(
	user_id integer not null auto_increment,
    user_name varchar(45) default null,
    email varchar(45) default null,
    mobile_no numeric default 0,
    address varchar(100) default null,
    primary key(user_id)
) ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=latin1;

drop table if exists `bank`;

create table `bank`(
	IFSC varchar(45) not null,
    bank_name varchar(45) default null,
    state varchar(45) default null,
    city varchar(45) default null,
    area varchar(45) default null,
    primary key(IFSC)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

drop table if exists `account`;

create table `account`(
	account_no varchar(45) not null,
    open_date date default null,
    IFSC varchar(45),
    `type` varchar(45),
    balance integer,
    currency varchar(45),
    primary key(account_no),
    foreign key(IFSC) references bank(IFSC)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

drop table if exists `transaction`;

create table `transaction`(
	transaction_id integer not null auto_increment,
    account_no varchar(45) not null,
    details varchar(45),
    cr_db varchar(10),
    amount integer,
    closing_balance integer,
    date datetime,
    primary key(transaction_id),
    foreign key(account_no) references account(account_no)
) ENGINE=InnoDB auto_increment=1000 DEFAULT  CHARSET=latin1;

alter table account add user_id integer;

alter table account add foreign key(user_id) references `user`(user_id);

alter table user add password varchar(45);

