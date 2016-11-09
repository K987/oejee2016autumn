SET PGCLIENTENCODING=utf-8

psql -d postgres -h localhost -p 5432 -U postgres -f create-database.sql
psql -d postgres -h localhost -p 5432 -U postgres -f create-role.sql
psql -d postgres -h localhost -p 5432 -U postgres -f create-user.sql
psql -d anglerregistry_db -h localhost -p 5432 -U postgres -f create-schema.sql
psql -d anglerregistry_db -h localhost -p 5432 -U postgres -f create-table.sql
psql -d anglerregistry_db -h localhost -p 5432 -U postgres -f grant-access.sql
psql -d anglerregistry_db -h localhost -p 5432 -U postgres -f initial-data.sql