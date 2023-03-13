CREATE TABLE tinder_user
( id bigint GENERATED ALWAYS AS IDENTITY primary key,
  user_email varchar(126) unique,
  password   varchar(100) NOT NULL,
  name varchar(126) NULL,
  city varchar(64) NULL,
  street varchar(126) NULL,
  post_code varchar(6) NULL,
  creation_timestamp timestamp NOT NULL,
  modification_timestamp timestamp NOT NULL
);