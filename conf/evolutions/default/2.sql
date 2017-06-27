# --- !Ups

INSERT INTO video (title, description, thumbnail, created_date, modified_date)
VALUES ('Tabby vs Black Cat', 'Cats fight each other', null, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
--VALUES ('Tabby vs Black Cat', 'Cats fight each other', FILE_READ('/Users/mvanbrummen/dev/scala/catThumbnails/cats1.jpg'), CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO video (title, description, thumbnail, created_date, modified_date)
VALUES ('Sphinx cat vs Burmese', 'Cat fight city', null, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO video (title, description, thumbnail, created_date, modified_date)
VALUES ('White cat vs ginger', 'Ranga cat mits up', null, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

# --- !Downs

DELETE
FROM video;