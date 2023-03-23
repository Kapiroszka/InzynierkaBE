create TABLE product
( id bigint GENERATED ALWAYS AS IDENTITY primary key,
  name varchar(126) unique,
  description   varchar(512)  NULL,
  category_id varchar(12) NOT NULL,
  sale_price decimal(18,2) NOT NULL,
  promotional_price decimal(18,2) NULL,
  quantity numeric NOT NULL,
  creation_timestamp timestamp NOT NULL,
  modification_timestamp timestamp NOT NULL,
  CONSTRAINT fk_customer
      FOREIGN KEY(category_id)
	  REFERENCES category(treeRepresentaion)
);
