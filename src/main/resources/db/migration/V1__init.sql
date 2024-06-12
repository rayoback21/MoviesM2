CREATE TABLE IF NOT EXISTS film (
    id SERIAL NOT NULL ,
    title VARCHAR(50) NOT NULL,
    director VARCHAR(50) NOT NULL,
    duration DECIMAL(10,2) NOT NULL ,
    release_date INT NOT NULL ,
    genre VARCHAR(30) NOT NULL ,
    box_office DECIMAL(15,2) NOT NULL,
    rating DECIMAL(3,2) NOT NULL,
    synopsis VARCHAR(100),
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS scene(
    id SERIAL NOT NULL,
    description VARCHAR(60) NOT NULL,
    budget DECIMAL(10,2) NOT NULL,
    minutes DECIMAL(10,2) NOT NULL,
    recording_location VARCHAR(100) NOT NULL ,
    date_shot DATE NOT NULL ,
    actors_involved TEXT NOT NULL,
    scene_type VARCHAR(50) NOT NULL,
    film_id INT,
    FOREIGN KEY (film_id) REFERENCES film(id),
    PRIMARY KEY (id)
    );


CREATE TABLE IF NOT EXISTS characters(
    id SERIAL NOT NULL,
    full_name VARCHAR(50) NOT NULL,
    description VARCHAR(60) NOT NULL,
    cost DECIMAL(10,2) NOT NULL,
    actor VARCHAR(50),
    costume VARCHAR(60) NOT NULL, -- Disfraz o vestimenta
    roles VARCHAR(50) NOT NULL, -- Ejemplo: Protagonista, Secundario, etc.
    scene_id INT,
    FOREIGN KEY (scene_id) REFERENCES scene(id),
    PRIMARY KEY (id)
    );