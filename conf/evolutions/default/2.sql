# --- !Ups

INSERT INTO video (title, description, thumbnail_location, video_location, likes, dislikes, views, created_date, modified_date)
VALUES ('Tabby vs Black Cat', 'Cats fight each other', './public/thumbnail/1.jpeg', './public/video/1.mp4', 109, 2, 10990, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());


# --- !Downs

DELETE
FROM video;