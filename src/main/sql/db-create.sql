DROP DATABASE IF EXISTS practice10db;
CREATE DATABASE practice10db;
USE practice10db;

CREATE TABLE roles
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE users
(
    login VARCHAR(15) NOT NULL UNIQUE,
    password VARCHAR(15) NOT NULL,
    role_id INT NOT NULL,
    KEY role_id_reference (role_id),
    CONSTRAINT role_id_reference FOREIGN KEY (role_id) REFERENCES
        roles (id) ON DELETE CASCADE
);

INSERT INTO roles
VALUES (1, 'Admin');
INSERT INTO roles
VALUES (2, 'Client');

INSERT INTO users
VALUES ('client1', '123456', 2);
INSERT INTO users
VALUES ('adminguy', '134862', 1);
