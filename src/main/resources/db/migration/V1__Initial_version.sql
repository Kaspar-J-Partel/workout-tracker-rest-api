CREATE TABLE user {
    id SERIAL primary key,
    first_name varchar not null,
    last_name varchar not null,
    age int,
    weight decimal,
    height decimal,
}

CREATE TABLE exercise {
    id SERIAL primary key,
    name varchar not null,
    type varchar not null,
    target varchar not null,
    description varchar not null,
    user_id integer not null references user(user_id) on delete cascade,
}

CREATE TABLE set {
    id SERIAL primary key,
    rep_count int not null,
    set_count int not null,
    workout_id integer references workout(workout_id),

}

CREATE TABLE exercise_set {
    exercise_id integer references exercise(exercise_id) on update cascade on delete cascade,
    set_id integer references set(set_id) on update cascade on delete cascade,
}

CREATE TABLE workout {
    id SERIAL primary key,
    type varchar not null,
    target varchar not null,
    description varchar,
    workout_collection_id integer not null references workout_collection(workout_collection_id),
    user_id integer not null references user(user_id)
}

CREATE TABLE workout_collection {
    id serial primary key,
}

INSERT INTO user VALUES("Kaspar Johannes", "Pärtel", 23, 76.1, 184.5)
INSERT INTO exercise VALUES("Pullup", "strength", "back", "Pull up on a bar", )