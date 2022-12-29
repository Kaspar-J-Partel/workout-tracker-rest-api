CREATE TABLE app_user
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    email      VARCHAR(70) NOT NULL UNIQUE,
    age        INT,
    weight     DECIMAL(4, 1),
    height     DECIMAL(4, 1),
    password   VARCHAR(30)
);

CREATE TABLE exercise
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(50)  NOT NULL,
    type        VARCHAR(30)  NOT NULL,
    target      VARCHAR(30)  NOT NULL,
    description VARCHAR(150) NOT NULL,
    user_id     INT          NOT NULL REFERENCES app_user (id) ON DELETE CASCADE
);

CREATE TABLE workout
(
    id          SERIAL PRIMARY KEY,
    type        VARCHAR(30) NOT NULL,
    target      VARCHAR(30) NOT NULL,
    description VARCHAR(150),
    user_id     INT         NOT NULL REFERENCES app_user (id) ON DELETE CASCADE
);

CREATE TABLE set
(
    id          SERIAL PRIMARY KEY,
    rep_count   INT NOT NULL,
    set_count   INT NOT NULL,
    exercise_id INT NOT NULL REFERENCES exercise (id) ON UPDATE CASCADE,
    workout_id  INT NOT NULL REFERENCES workout (id) ON DELETE CASCADE
);

INSERT INTO app_user (first_name, last_name, email, age, weight, height, password)
VALUES ('Kaspar Johannes', 'Pärtel', 'kasparjohannes@gmail.com', 23, 76.1, 184.5, '123456');

INSERT INTO exercise (name, type, target, description, user_id)
VALUES ('Pullup', 'strength', 'back', 'Pull up on a bar', 1);

INSERT INTO exercise (name, type, target, description, user_id)
VALUES ('Pushup', 'strength', 'triceps', 'Push up without weight', 1);

INSERT INTO workout (type, target, description, user_id)
VALUES ('strength', 'back', 'Back workout', 1);

INSERT INTO set (rep_count, set_count, exercise_id, workout_id)
VALUES (10, 3, 1, 1);

INSERT INTO set (rep_count, set_count, exercise_id, workout_id)
VALUES (12, 5, 1, 1);
