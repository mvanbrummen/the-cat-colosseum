# --- !Ups

CREATE TABLE video (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    title varchar(50) NOT NULL,
    description varchar(255) NOT NULL,
    thumbnail_location varchar(MAX) NOT NULL,
    video_location varchar(MAX) NOT NULL,
    likes bigint DEFAULT 0,
    dislikes bigint DEFAULT 0,
    views bigint DEFAULT 0,
    created_date timestamp DEFAULT CURRENT_TIMESTAMP,
    modified_date timestamp DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);


# --- !Downs

DROP TABLE video;
