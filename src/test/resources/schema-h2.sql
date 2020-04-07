CREATE TABLE difficulties
(
    id INT PRIMARY KEY,
    description VARCHAR(50)
);

CREATE TABLE lessons
(
    id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    discussion VARCHAR(500),
    difficulty INT,
    thumbnail VARCHAR(255),
    audio VARCHAR(255),
    FOREIGN KEY (difficulty) REFERENCES difficulties(id)
);


INSERT INTO difficulties (id, description) VALUES (1, 'Absolute Beginners');
INSERT INTO difficulties (id, description) VALUES (2, 'Elementary');
INSERT INTO difficulties (id, description) VALUES (3, 'Intermediate');
INSERT INTO difficulties (id, description) VALUES (4, 'Advanced');

INSERT INTO lessons (id, title, discussion, thumbnail, difficulty, audio)
VALUES(1, 'My first lesson', 'This is the discussion', 'https://www.thumbnail.com', 1, 'https://myaudio.de');