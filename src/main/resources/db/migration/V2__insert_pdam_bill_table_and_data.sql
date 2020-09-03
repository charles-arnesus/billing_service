CREATE TABLE pdam_bill
(
    biller_id VARCHAR(255) NOT NULL,
    customer_account_id VARCHAR(255) NOT NULL,
    due_date DATE NOT NULL,
    payment_date DATE,
    payment_id uuid,
    status VARCHAR(255),
    total_amount DOUBLE PRECISION
);

ALTER TABLE pdam_bill ADD CONSTRAINT pdam_bill_pk PRIMARY KEY (biller_id, customer_account_id, due_date);

INSERT INTO pdam_bill(
	biller_id, customer_account_id, due_date,  status, total_amount)
	VALUES ('pdam_bandung', '112233', '2020-09-20', 'available', 110000),
	('pdam_bandung', '112233', '2020-08-20', 'available', 120000),
	('pdam_bandung', '112233', '2020-07-20', 'available', 130000);
