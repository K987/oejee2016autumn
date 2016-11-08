CREATE OR REPLACE VIEW transactions AS
	SELECT e.expense_doc_id,
	 e.expense_doc_type, 
	 e.expense_issuer, 
	 e.expense_payment_method, 
	 e.expense_gross_amount, 
	 e.expense_description,
	 dateregistered,
	 dateexpiry,
	 datepayed,
	 dateaccPeriod,
	 dateLastModifiedAt,
	 fateLastModifiedBy
	 FROM expenses e