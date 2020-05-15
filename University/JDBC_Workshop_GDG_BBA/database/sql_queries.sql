DROP DATABASE IF EXISTS jdbc_workshop_db;

CREATE DATABASE jdbc_workshop_db;

USE jdbc_workshop_db;

CREATE TABLE employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30),
    gender BOOLEAN,
    salary REAL
);