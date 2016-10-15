-- create database and access
CREATE DATABASE restofficedb;
CREATE ROLE ro_crud_role WITH NOSUPERUSER NOCREATEDB NOCREATEROLE;
CREATE USER ro_crud_user;
ALTER USER ro_crud_user PASSWORD 'pwd123';
GRANT ro_crud_role TO ro_crud_user;
