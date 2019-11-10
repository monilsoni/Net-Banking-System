

SHOW VARIABLES LIKE 'validate_password%';

SET GLOBAL validate_password_length = 10;
set global validate_password_policy = 'LOW';
SET GLOBAL validate_password_number_count = 0;

CREATE USER 'netbanking'@'localhost' IDENTIFIED BY 'netbanking';

GRANT ALL PRIVILEGES ON * . * TO 'netbanking'@'localhost';

#
# Starting with MySQL 8.0.4, the MySQL team changed the 
# default authentication plugin for MySQL server 
# from mysql_native_password to caching_sha2_password.
#
# The command below will make the appropriate updates for your user account.
#
# See the MySQL Reference Manual for details: 
# https://dev.mysql.com/doc/refman/8.0/en/caching-sha2-pluggable-authentication.html
#