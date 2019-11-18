DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);


INSERT INTO meals (user_id, datetime, description, calories) VALUES
  (100000, '17.11.2019T11:04:15.215', 'Сніданок', 650),
  (100000, '17.11.2019T16:04:15.215', 'Обід', 450),
  (100000, '17.11.2019T22:04:15.215', 'Вечеря', 700),
  (100001, '17.11.2019T11:04:15.215', 'Сніданок', 550),
  (100001, '17.11.2019T16:04:15.215', 'Обід', 750),
  (100001, '17.11.2019T22:04:15.215', 'Вечеря', 800);

