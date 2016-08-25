DROP DATABASE IF EXISTS sampledb;
CREATE DATABASE sampledb DEFAULT  CHARACTER SET utf8;
USE sampledb;

# user table
CREATE TABLE t_user(
  user_id INT AUTO_INCREMENT PRIMARY KEY ,
  user_name VARCHAR(30),
  credits INT,
  password VARCHAR(32),
  last_visit datetime,
  last_ip VARCHAR(23)
)ENGINE=InnoDB;

#  login log table
CREATE TABLE t_login_log(
  login_log_id INT AUTO_INCREMENT PRIMARY KEY ,
  user_id INT,
  ip VARCHAR(23),
  login_datetime datetime
)ENGINE=InnoDB;


# DATA

INSERT INTO t_user (user_name,password)VALUES('admin','123456');

