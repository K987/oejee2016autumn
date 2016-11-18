select employee_name, shift_start_d from employees left join employee_shift on (employee_id = employee_shift_employee_id) left join shifts on (employee_shift_shift_id = shift_id)
where employee_name = 'Ond Kond' and shift_start_d between '2016-11-01' and '2016-11-30';

select count(e.employee_name) from employees e 
join employee_shift es on (employee_id = employee_shift_employee_id) 
join shifts s on (employee_shift_shift_id = shift_id) 
where employee_name = 'Ond Kond' and s.shift_start_d < '2016-11-18' and es.employee_shift_actual_start is not null; 

--partner queries

select * from partners;



--employee queries

select * from employee_shift join shifts on (employee_shift_shift_id = shift_id) where employee_shift_employee_id = 2;

select * from shifts;

select * from daily_incomes join employee_shift on(daily_income_employee_shift=employee_shift_id) where employee_shift_actual_start is null;

