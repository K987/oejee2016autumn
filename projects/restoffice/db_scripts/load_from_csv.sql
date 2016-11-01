COPY partners(partner_name,partner_account,partner_contact_name,partner_contact_email,partner_contact_phone,parnter_technical)
FROM '/Volumes/MacHDD1/oejee2016autumn/projects/restoffice/db_scripts/partners.csv' DELIMITER ',' CSV HEADER;

COPY exp_types(exp_type_name,exp_type_prod_related)
FROM '/Volumes/MacHDD1/oejee2016autumn/projects/restoffice/db_scripts/exp_types.csv' DELIMITER ',' CSV HEADER;

COPY inc_types(inc_type_name,inc_type_prod_related)
FROM '/Volumes/MacHDD1/oejee2016autumn/projects/restoffice/db_scripts/inc_types.csv' DELIMITER ',' CSV HEADER;

COPY cost_centers(cost_center_name,cost_center_default)
FROM '/Volumes/MacHDD1/oejee2016autumn/projects/restoffice/db_scripts/cost_centers.csv' DELIMITER ',' CSV HEADER;
