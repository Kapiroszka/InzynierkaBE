create TABLE Cart_product
( id bigint GENERATED ALWAYS AS IDENTITY primary key,
  cart_id bigint   REFERENCES cart(id) NOT NULL,
  product_id bigint  REFERENCES product(id) NOT NULL,
  quantity   numeric  NULL,
  price_per_item  decimal(18,2) NOT NULL,
  creation_timestamp timestamp NOT NULL
);
