create TABLE category
( id bigint GENERATED ALWAYS AS IDENTITY primary key,
  name varchar(126) NOT NULL,
  treeRepresentaion varchar(12) NOT NULL unique,
  creation_timestamp timestamp NOT NULL,
  modification_timestamp timestamp NOT NULL
);