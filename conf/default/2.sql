# --- !Ups

INSERT INTO Video (title, description, thumbnail, created_date, modified_date)
VALUES ('Tabby vs Black Cat', 'Cats fight each other', FILE_READ('/Users/mvanbrummen/dev/scala/catThumbnails'), now(), now());


# --- !Downs

DELETE
FROM Video;