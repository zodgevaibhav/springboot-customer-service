create database customerdb;
use customerdb;
drop user vzodge;
flush privileges;
create user 'vzodge'@'%' identified by 'password123';
GRANT ALL PRIVILEGES ON *.* TO 'vzodge'@'%'with grant option;
flush privileges;
