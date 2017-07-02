# --- !Ups

INSERT INTO video (title, description, thumbnail, likes, dislikes, views, created_date, modified_date)
VALUES ('Tabby vs Black Cat', 'Cats fight each other', FILE_READ('/Users/mvanbrummen/dev/scala/catThumbnails/cats1.jpg'), 109, 2, 10990, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO video (title, description, thumbnail, created_date, modified_date)
VALUES ('Aggressive Ginger vs White Cat', 'Cats fight each other', FILE_READ('/Users/mvanbrummen/dev/scala/catThumbnails/cats2.jpeg'), CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO video (title, description, thumbnail, created_date, modified_date)
VALUES ('Two Cats, One Bucket', 'Cats fight each other', FILE_READ('/Users/mvanbrummen/dev/scala/catThumbnails/cats3.jpeg'), CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO video (title, description, thumbnail, created_date, modified_date)
VALUES ('Fight Cat', 'Cats fight each other', FILE_READ('/Users/mvanbrummen/dev/scala/catThumbnails/cats4.jpeg'), CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO video (title, description, thumbnail, created_date, modified_date)
VALUES ('Brutal Siamese!!!', 'Cats fight each other', FILE_READ('/Users/mvanbrummen/dev/scala/catThumbnails/cats5.jpeg'), CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO video (title, description, thumbnail, created_date, modified_date)
VALUES ('Wow. Much Cat. So Meow', 'Cats fight each other', FILE_READ('/Users/mvanbrummen/dev/scala/catThumbnails/cats6.jpeg'), CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO video (title, description, thumbnail, created_date, modified_date)
VALUES ('Gammy Nums Nums Kitty', 'Cats fight each other', FILE_READ('/Users/mvanbrummen/dev/scala/catThumbnails/cats7.jpeg'), CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO video (title, description, thumbnail, created_date, modified_date)
VALUES ('Pussy Cat Galore', 'Cats fight each other', FILE_READ('/Users/mvanbrummen/dev/scala/catThumbnails/cats8.jpeg'), CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO video (title, description, thumbnail, created_date, modified_date)
VALUES ('Garfield Resurrection', 'Cats fight each other', FILE_READ('/Users/mvanbrummen/dev/scala/catThumbnails/cats9.jpeg'), CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO video (title, description, thumbnail, created_date, modified_date)
VALUES ('Meow Meow Meow', 'Cats fight each other', FILE_READ('/Users/mvanbrummen/dev/scala/catThumbnails/cats10.jpeg'), CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO video (title, description, thumbnail, created_date, modified_date)
VALUES ('Lorem Ipsum Meow', 'Cats fight each other', FILE_READ('/Users/mvanbrummen/dev/scala/catThumbnails/cats11.jpeg'), CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO video (title, description, thumbnail, created_date, modified_date)
VALUES ('Black Cat Attack', 'Cats fight each other', FILE_READ('/Users/mvanbrummen/dev/scala/catThumbnails/cats12.jpeg'), CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());


# --- !Downs

DELETE
FROM video;