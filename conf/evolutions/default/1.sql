# --- !Ups

CREATE TABLE video (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    title varchar(50) NOT NULL,
    description varchar(255) NOT NULL,
    thumbnail image,
    created_date timestamp NOT NULL,
    modified_date timestamp NOT NULL,
    PRIMARY KEY(id)
);


# --- !Downs

DROP TABLE video;
