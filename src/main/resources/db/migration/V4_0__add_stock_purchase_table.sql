create TABLE stock_purchase
( id bigint GENERATED ALWAYS AS IDENTITY primary key,
  product_id bigint unique,
  quantity   numeric  NULL,
  price_per_item  decimal(18,2) NOT NULL,
  creation_timestamp timestamp NOT NULL,
  CONSTRAINT fk_product_id
      FOREIGN KEY(product_id)
	  REFERENCES product(id)
);
