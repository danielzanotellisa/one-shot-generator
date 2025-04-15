CREATE TABLE character(

    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    age INTEGER NOT NULL,
    species VARCHAR(255) NOT NULL,
    character_class VARCHAR(255) NOT NULL,
    character_level INTEGER NOT NULL
);