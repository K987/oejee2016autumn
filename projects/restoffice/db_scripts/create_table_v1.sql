--create tables and configure
CREATE TABLE expense_types(
  expense_t_ID SERIAL PRIMARY KEY,
  expense_t_name VARCHAR(100) NOT NULL UNIQUE,
  expense_t_production BOOLEAN NOT NULL
  );
ALTER TABLE expense_types OWNER TO postgres;
--CREATE UNIQUE INDEX UI_EXPENSE_NAME ON expense_types USING btree (expense_t_name);

CREATE TABLE income_types(
  income_t_ID SERIAL PRIMARY KEY,
  income_t_name VARCHAR(100) NOT NULL UNIQUE,
  income_t_production BOOLEAN NOT NULL
  );
ALTER TABLE income_types OWNER TO postgres;
--CREATE UNIQUE INDEX UI_INCOME_NAME ON income_types USING btree (income_t_name);


CREATE TABLE doc_types(
  doc_type_ID SERIAL PRIMARY KEY,
  doc_type_name VARCHAR(100) NOT NULL UNIQUE,
  doc_type_internal BOOLEAN NOT NULL,
  doc_type_final BOOLEAN NOT NULL
  );
ALTER TABLE doc_types OWNER TO postgres;
--CREATE UNIQUE INDEX UI_DOC_NAME ON doc_types USING btree (doc_type_name);

CREATE TABLE partners(
  parnter_ID SERIAL PRIMARY KEY,
  partner_bank_account INTEGER UNIQUE,
  partner_name VARCHAR(200) NOT NULL,
  partner_address VARCHAR(200),
  partner_contact VARCHAR(200),
  parnter_technical BOOLEAN NOT NULL
  );
ALTER TABLE partners OWNER TO postgres;

CREATE TABLE payment_methods(
  payment_m_ID SERIAL PRIMARY KEY,
  payment_m_name VARCHAR(100) NOT NULL UNIQUE,
  payment_m_postponed BOOLEAN NOT NULL
  );
ALTER TABLE payment_methods OWNER TO postgres;
--CREATE UNIQUE INDEX UI_PAYMENT_METHOD_NAME ON payment_methods btree (payment_m_name);

CREATE TABLE cost_centers(
  costcenter_ID SERIAL PRIMARY KEY,
  costcenter_name VARCHAR(100) NOT NULL UNIQUE,
  constcenter_production BOOLEAN NOT NULL
  );
ALTER TABLE cost_centers OWNER TO postgres;
--CREATE UNIQUE INDEX UI_CC_NAME ON cost_centers USING btree (costcenter_name);

CREATE TABLE users(
  user_ID VARCHAR(50) PRIMARY KEY,
  user_PW VARCHAR(50) NOT NULL,
  user_name VARCHAR(100),
  user_role VARCHAR(50)
  );
ALTER TABLE users OWNER TO postgres;

CREATE TABLE expenses(
  expense_doc_ID VARCHAR(100) NOT NULL,
  expense_doc_part INTEGER NOT NULL,
  expense_due_date DATE NOT NULL,
  expense_expiry_date DATE,
  expense_gross_amount NUMERIC NOT NULL,
  expense_vat INTEGER NOT NULL,
  expense_payment_method INTEGER NOT NULL,
  expense_costcenter INTEGER NOT NULL,
  expense_type INTEGER NOT NULL,
  expense_description VARCHAR(200),
  expense_beneficiary INTEGER NOT NULL,
  expense_accounting_period DATE,
  expense_proof_of_payment VARCHAR(100),
  expense_doc_type INTEGER NOT NULL,
  expense_last_modified_by VARCHAR(50) NOT NULL,
  expense_last_modified_dt TIMESTAMP NOT NULL,
  CONSTRAINT PK_EXPENSES PRIMARY KEY (expense_doc_ID, expense_doc_part),
  CONSTRAINT FK_EXP_PAYMENT_METHOD FOREIGN KEY (expense_payment_method) REFERENCES
  payment_methods (payment_m_ID),
  CONSTRAINT FK_EXP_COST_CENTER FOREIGN KEY (expense_costcenter) REFERENCES
  cost_centers (costcenter_ID),
  CONSTRAINT FK_EXP_EXPENSE_TYPE FOREIGN KEY (expense_type) REFERENCES
  expense_types (expense_t_ID),
  CONSTRAINT FK_EXP_BENEFICIARY FOREIGN KEY (expense_beneficiary) REFERENCES
  partners (parnter_ID),
  CONSTRAINT FK_EXP_DOC_TYPE FOREIGN KEY (expense_doc_type) REFERENCES
  doc_types (doc_type_ID),
  CONSTRAINT FK_EXP_MODIFIER FOREIGN KEY (expense_last_modified_by) REFERENCES
  users (user_ID)
);
ALTER TABLE expenses OWNER TO postgres;


CREATE TABLE incomes(
  income_doc_ID VARCHAR(100) NOT NULL,
  income_doc_part INTEGER NOT NULL,
  income_due_date DATE NOT NULL,
  income_expiry_date DATE,
  income_gross_amount NUMERIC NOT NULL,
  income_vat INTEGER NOT NULL,
  income_payment_method INTEGER NOT NULL,
  income_costcenter INTEGER NOT NULL,
  income_type INTEGER NOT NULL,
  income_description VARCHAR(200),
  income_liable INTEGER NOT NULL,
  income_accounting_period DATE,
  income_proof_of_payment VARCHAR(100),
  income_doc_type INTEGER NOT NULL,
  income_last_modified_by VARCHAR(50) NOT NULL,
  income_last_modified_dt TIMESTAMP NOT NULL,
  CONSTRAINT PK_INCOMES PRIMARY KEY (income_doc_ID, income_doc_part),
  CONSTRAINT FK_INC_PAYMENT_METHOD FOREIGN KEY (income_payment_method) REFERENCES
  payment_methods (payment_m_ID),
  CONSTRAINT FK_INC_COST_CENTER FOREIGN KEY (income_costcenter) REFERENCES
  cost_centers (costcenter_ID),
  CONSTRAINT FK_INC_EXPENSE_TYPE FOREIGN KEY (income_type) REFERENCES
  income_types (income_t_ID),
  CONSTRAINT FK_INC_BENEFICIARY FOREIGN KEY (income_liable) REFERENCES
  partners (parnter_ID),
  CONSTRAINT FK_INC_DOC_TYPE FOREIGN KEY (income_doc_type) REFERENCES
  doc_types (doc_type_ID),
  CONSTRAINT FK_INC_MODIFIER FOREIGN KEY (income_last_modified_by) REFERENCES
  users (user_ID)
  );
ALTER TABLE incomes OWNER TO postgres;
