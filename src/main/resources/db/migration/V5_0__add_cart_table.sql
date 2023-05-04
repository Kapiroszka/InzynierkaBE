create TABLE Cart
( id bigint GENERATED ALWAYS AS IDENTITY primary key,
  customer_id bigint  REFERENCES customer(id) NOT NULL,
  cart_value   decimal(18,2)  NOT NULL,
  creation_timestamp timestamp NOT NULL
);
