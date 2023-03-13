CREATE TABLE product
( id bigint GENERATED ALWAYS AS IDENTITY primary key,
  name varchar(126) unique,
  description   varchar(512)  NULL,
  category_id bigint NOT NULL,
  sale_price number NOT NULL,
  promotional_price number NULL,
  quantity number NOT NULL,
  creation_timestamp timestamp NOT NULL,
  modification_timestamp timestamp NOT NULL
);