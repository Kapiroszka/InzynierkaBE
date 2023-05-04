create TABLE stock_purchase
( id bigint GENERATED ALWAYS AS IDENTITY primary key,
  product_id bigint 	  REFERENCES product(id) unique,
  quantity   numeric  NULL,
  price_per_item  decimal(18,2) NOT NULL,
  creation_timestamp timestamp NOT NULL
);
