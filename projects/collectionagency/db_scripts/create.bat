psql -d postgres -h localhost -p 5432 -U postgres -f create_databasedatabase.sql
psql -d postgres -h localhost -p 5432 -U postgres -f create_role.sql
psql -d postgres -h localhost -p 5432 -U postgres -f create_user.sql
psql -d collectionagencydb -h localhost -p 5432 -U postgres -f create_schema.sql
psql -d collectionagencydb -h localhost -p 5432 -U postgres -f initial_data.sql