GRANT SELECT, INSERT, UPDATE, DELETE ON
shifts,
daily_incomes,
employee_shift,
registers,
register_closes,
partners,
expenses,
incomes,
exp_types,
cost_centers,
users,
inc_types,
employees TO ro_crud_role;

GRANT USAGE, SELECT, UPDATE ON
cost_centers_cost_center_id_seq,
daily_incomes_daily_income_id_seq,
employee_shift_employee_shift_id_seq,
employees_employee_id_seq,
exp_types_exp_type_id_seq,
inc_types_inc_type_id_seq,
partners_parnter_id_seq,
shifts_shift_id_seq TO ro_crud_role;
