DELETE
FROM user_role;
DELETE
FROM users;
DELETE
FROM meals;

ALTER SEQUENCE global_seq RESTART WITH 100000;
ALTER SEQUENCE meals_id RESTART WITH 1;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Guest', 'guest@gmail.com', 'guest');

INSERT INTO user_role (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);


INSERT INTO meals (user_id, datetime, description, calories)
VALUES ('100000', '2023-03-02 09:54:00', 'Завтрак', '900'),
       ('100000', '2023-03-04 12:43:00', 'Обед', '700'),
       ('100000', '2023-03-05 18:12:00', 'Ужин', '400');