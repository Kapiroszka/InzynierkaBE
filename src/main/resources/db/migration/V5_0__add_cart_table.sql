create TABLE Cart
( id varchar(36) primary key,
  customer_id bigint  REFERENCES customer(id) NOT NULL,
  cart_value   decimal(18,2)  NOT NULL,
  creation_timestamp timestamp NOT NULL
);
