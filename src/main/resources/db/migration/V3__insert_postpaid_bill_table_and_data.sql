CREATE TABLE postpaid_bill
(
    biller_id VARCHAR(255) NOT NULL,
    customer_account_id VARCHAR(255) NOT NULL,
    due_date DATE NOT NULL,
    payment_date DATE,
    payment_id uuid,
    status VARCHAR(255),
    total_amount DOUBLE PRECISION
);

ALTER TABLE postpaid_bill ADD CONSTRAINT postpaid_bill_pk PRIMARY KEY (biller_id, customer_account_id, due_date);

INSERT INTO postpaid_bill(
	biller_id, customer_account_id, due_date,  status, total_amount)
	VALUES ('halo', '08123456789', '2020-09-20', 'available', 110000),
	('halo', '08123456789', '2020-08-20', 'available', 120000),
	('halo', '08123456789', '2020-07-20', 'available', 130000);