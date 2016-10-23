create table users(
user_id number,
pswd varchar2(100),
username varchar2(100),
email varchar2(100),
is_admin number,
constraint pk_user_id primary key(user_id)
)

create table customers(
customer_id number,
customer_name varchar2(100),
email varchar2(100),
zip number,
city varchar2(100),
address varchar2(100),
constraint pk_customer_id primary key(customer_id)
)

create table case_types(
case_type_id number,
description varchar2(30),
constraint pk_case_type_id primary key(case_type_id)
)

create table cases(
case_id number,
case_type_id number,
customer_id number,
debt number,
balance number,
start_date date,
end_date date,
status number,
constraint pk_case_id primary key(case_id)
constraint fk_cas_cus foreign key (customer_id) REFERENCES customers (customer_id)
constraint fk_cas_typ foreign key (case_id) REFERENCES case_types (case_type_id)
)

create table events(
event_id number,
case_id number,
customer_id number,
event_type_id number,
event_text varchar2(150),
status number,
constraint pk_event_id primary key(event_id),
constraint fk_ev_cas foreign key (case_id) REFERENCES cases (case_id),
constraint fk_ev_cus foreign key (customer_id) REFERENCES customers (customer_id),
constraint fk_ev_evtyp foreign key (event_type) REFERENCES event_types (event_type_id)
)

create table event_types(
event_type_id number,
description varchar2(30),
constraint pk_event_type_id primary key(event_type_id)
)

create table payment_types(
payment_type_id number,
description varchar2(25),
constraint pk_payment_type_id primary key(payment_type_id),
)

create table agreements(
AGREEMENT_ID number,
AGREED_PERSON varchar2(50),
AGREED_FIRST_FUD date,
AGREED_ACTUAL_FUD date,
AGREED_AMOUNT number,
INSTALMENT_RACE number,
INSTALMENT_AMOUNT number,
PAYMENT_TYPE_id number,
IS_OPEN number,
EVENT_ID number,
constraint pk_agreement_id primary key(agreement_id),
constraint fk_ag_ev foreign key (event_id) REFERENCES events (event_id),
constraint fk_ag_paytyp foreign key (payment_type_id) REFERENCES payment_types (payment_type_id),
)

create table documents(
document_id number,
customer_id number,
case_id number,
event_id number,
path varchar2(200),
creation_date date,
constraint pk_document_id primary key(document_id),
constraint fk_doc_ev foreign key (event_id) REFERENCES events (event_id),
constraint fk_doc_cas foreign key (case_id) REFERENCES cases (case_id),
constraint fk_doc_cus foreign key (customer_id) REFERENCES customers (customer_id)
)