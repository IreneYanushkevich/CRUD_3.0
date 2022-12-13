CREATE TABLE IF NOT EXISTS labels(
    label_id SERIAL PRIMARY KEY,
    name VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS writers(
    writer_id SERIAL PRIMARY KEY,
    firstname VARCHAR (30) NOT NULL,
    lastname VARCHAR (30) NOT NULL
);

CREATE TABLE IF NOT EXISTS posts(
    post_id SERIAL PRIMARY KEY,
    content TEXT NOT NULL UNIQUE,
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP NOT NULL,
    post_status VARCHAR(10) NOT NULL,
    writer_id INTEGER,
    FOREIGN KEY (writer_id) REFERENCES writers (writer_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS posts_labels(
    post_id INTEGER NOT NULL,
    label_id INTEGER NOT NULL,
    PRIMARY KEY (post_id, label_id),
    UNIQUE (post_id, label_id),
    CONSTRAINT fk_label_post_id
    FOREIGN KEY (post_id) REFERENCES posts (post_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_post_label_id
    FOREIGN KEY (label_id) REFERENCES labels (label_id) ON DELETE CASCADE ON UPDATE CASCADE
);