             CREATE TABLE users (
  id SERIAL PRIMARY KEY not null,
  username VARCHAR(100) not null,
  firstname VARCHAR(100) not null,
  lastname VARCHAR(100)  not null
);

INSERT INTO users (username, firstname, lastname) VALUES ('jking@gmail.com', 'John', 'King');
INSERT INTO users (username, firstname, lastname) VALUES ('cjohnson@gmail.com', 'Carla', 'Johnson');