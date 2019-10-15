DROP DATABASE  IF EXISTS `userbase`;

CREATE DATABASE  IF NOT EXISTS `userbase`;
USE `userbase`;

DROP TABLE IF EXISTS `user_roles`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE users (
	userid int(11) NOT NULL AUTO_INCREMENT,
	username VARCHAR(45) NOT NULL,
	email VARCHAR(255) NOT NULL,
	password VARCHAR(60) NOT NULL ,
	enabled TINYINT NOT NULL DEFAULT 1 ,
	PRIMARY KEY (userid)
  );

CREATE TABLE user_roles (
	user_role_id int(11) NOT NULL AUTO_INCREMENT,
	userid int(11) NOT NULL,
	role varchar(45) NOT NULL,
	PRIMARY KEY (user_role_id),
	UNIQUE KEY uni_userid_role (role,userid),
	KEY fk_user_idx (userid),
	CONSTRAINT fk_userid FOREIGN KEY (userid) REFERENCES users (userid)
);

INSERT INTO users(username,email,password,enabled)
VALUES 
('monil','abc@abc.com','{noop}test123',1),
('bhavik','abc@abc.com','{noop}test123',1),
('pokharmal','abc@abc.com','{noop}test123',1);

INSERT INTO user_roles (userid, role)
VALUES 
(1, 'ROLE_USER'),
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER'),
(2, 'ROLE_MANAGER'),
(3, 'ROLE_USER');