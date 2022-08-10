BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, animal_types, animals, animal_photos, stories CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE animal_types (
    animal_type_id SERIAL, 
    type VARCHAR(50) NOT NULL,
    CONSTRAINT PK_animal_types PRIMARY KEY (animal_type_id)
);

CREATE TABLE animals (
    animal_id SERIAL,
    name VARCHAR(50) NOT NULL,
    breed VARCHAR(50) DEFAULT 'unknown',
    age int NOT NULL, 
    bio VARCHAR(500),
    animal_type_id int NOT NULL,
    CONSTRAINT PK_animals PRIMARY KEY (animal_id),
    CONSTRAINT FK_animal_type FOREIGN KEY (animal_type_id) REFERENCES animal_types (animal_type_id)
);

CREATE TABLE animal_photos (
    photo_id SERIAL,
    photo_link VARCHAR(1000) NOT NULL,
    animal_id int NOT NULL,
    CONSTRAINT PK_animal_photos PRIMARY KEY (photo_id),
    CONSTRAINT FK_animals FOREIGN KEY (animal_id) REFERENCES animals (animal_id)
);

CREATE TABLE stories (
	story_id SERIAL,
	story_title varchar(50) NOT NULL,
	story_text varchar(1000) NOT NULL,
	animal_id int NOT NULL,
	CONSTRAINT PK_story PRIMARY KEY (story_id), 
	CONSTRAINT FK_animals FOREIGN KEY (animal_id) REFERENCES animals (animal_id)
);


INSERT INTO animal_types (type) values('dog');
INSERT INTO animal_types (type) values('cat');
INSERT INTO animal_types (type) values('farm');
INSERT INTO animal_types (type) values('small');

COMMIT TRANSACTION;
