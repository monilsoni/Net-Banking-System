DROP DATABASE IF EXISTS `netbanking_test`;
CREATE DATABASE  IF NOT EXISTS `netbanking_test`;
USE `netbanking_test`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `user_id` INTEGER NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL UNIQUE,
    `password` VARCHAR(60) NOT NULL,
    `name` VARCHAR(45) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `mobile_no` NUMERIC NOT NULL,
    `address` VARCHAR(100) NOT NULL,
    `enabled` TINYINT(4) NOT NULL DEFAULT '1',
    PRIMARY KEY (`user_id`)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
    `user_role_id` INT(11) NOT NULL AUTO_INCREMENT,
    `user_id` INT(11) NOT NULL,
    `role` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`user_role_id`),
    UNIQUE KEY `uni_userid_role` (`role` , `user_id`),
    KEY `fk_user_idx` (`user_id`),
    CONSTRAINT `fk_userid` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`user_id`)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;

DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
    `IFSC` VARCHAR(45) NOT NULL,
    `bank_name` VARCHAR(45) DEFAULT NULL,
    `state` VARCHAR(45) DEFAULT NULL,
    `city` VARCHAR(45) DEFAULT NULL,
    `area` VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`IFSC`)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
    `account_no` VARCHAR(45) NOT NULL,
    `user_id` INTEGER NOT NULL,
    `open_date` DATE DEFAULT NULL,
    `IFSC` VARCHAR(45),
    `type` VARCHAR(45),
    `balance` INTEGER,
    `currency` VARCHAR(45),
    PRIMARY KEY (`account_no`),
    FOREIGN KEY (`IFSC`) REFERENCES `bank` (`IFSC`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
    `transaction_id` INTEGER NOT NULL AUTO_INCREMENT,
    `account_no` VARCHAR(45) NOT NULL,
    `details` VARCHAR(45),
    `cr_db` VARCHAR(10),
    `amount` INTEGER,
    `closing_balance` INTEGER,
    date DATETIME,
    PRIMARY KEY (`transaction_id`),
    FOREIGN KEY (`account_no`)
        REFERENCES account (`account_no`)
)  ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=LATIN1;