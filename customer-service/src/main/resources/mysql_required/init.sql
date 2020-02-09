create database customerdb;
use customerdb;
create user 'vzodge'@'%' identified by 'password123';
GRANT ALL PRIVILEGES ON *.* TO 'vzodge'@'%'with grant option;
flush privileges;