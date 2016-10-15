GRANT SELECT, INSERT, UPDATE, DELETE ON
cost_centers, doc_types, expense_types, expenses, income_types, incomes, partners, payment_methods, users
TO ro_crud_role;

GRANT USAGE, SELECT, UPDATE ON
cost_centers_costcenter_id_seq, doc_types_doc_type_id_seq, expense_types_expense_t_id_seq, income_types_income_t_id_seq, partners_parnter_id_seq, payment_methods_payment_m_id_seq
TO ro_crud_role;
