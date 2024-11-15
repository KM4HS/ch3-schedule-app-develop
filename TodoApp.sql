CREATE SCHEMA `todo-app`;
USE `todo-app`;

CREATE TABLE `todo`
(
    id          BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    contents    LONGTEXT,
    created_at  DATETIME(6),
    modified_at DATETIME(6),
    user_id     BIGINT
);

CREATE TABLE `user`
(
    id          BIGINT              NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255)        NOT NULL,
    username    VARCHAR(255) UNIQUE NOT NULL,
    password    VARCHAR(255)        NOT NULL,
    created_at  DATETIME(6),
    modified_at DATETIME(6)
);

ALTER TABLE `todo`
    ADD FOREIGN KEY (user_id)
        REFERENCES `user` (id);