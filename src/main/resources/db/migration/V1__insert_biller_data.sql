CREATE TABLE biller (
  biller_id VARCHAR(50),
  biller_name VARCHAR(50),
  category VARCHAR(50)
);

ALTER TABLE biller ADD CONSTRAINT biller_pk PRIMARY KEY (biller_id);

INSERT INTO biller(
	biller_id, biller_name, category)
	VALUES ('halo', 'Halo Postpaid', 'postpaid'),
	('pdam_bandung', 'PDAM Tirtawening', 'pdam');