BEGIN TRANSACTION;


DROP TABLE IF EXISTS users, animal_types, animals, animal_photos, stories, volunteers, volunteers_users CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	password_reset boolean DEFAULT false,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE volunteers (
	volunteer_id SERIAL,
	full_name varchar(100) NOT NULL,
	phone_number varchar (20) NOT NULL,
	email varchar(50) NOT NULL UNIQUE,
	bio text NOT NULL,
	ref_full_name varchar(100) NOT NULL,
	ref_phone_number varchar (20) NOT NULL,
	ref_email varchar(50) NOT NULL UNIQUE,
	app_status varchar(15) DEFAULT 'PENDING',
	CONSTRAINT UQ_email UNIQUE(email),
	CONSTRAINT UQ_ref_email UNIQUE(ref_email),
	CONSTRAINT PK_volunteers PRIMARY KEY (volunteer_id)
	
);

CREATE TABLE volunteers_users (
	volunteer_id int NOT NULL,
	user_id int NOT NULL,
	CONSTRAINT PK_volunteers_users PRIMARY KEY (volunteer_id, user_id)
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
    adopted boolean DEFAULT 'false',
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

ALTER TABLE volunteers_users ADD CONSTRAINT FK_volunteers_users_volunteer FOREIGN KEY(volunteer_id) REFERENCES volunteers(volunteer_id);
ALTER TABLE volunteers_users ADD CONSTRAINT FK_volunteers_users_user FOREIGN KEY(user_id) REFERENCES users(user_id);


COMMIT TRANSACTION;

