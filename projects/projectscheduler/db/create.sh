#!/bin/sh

cat create-database.sql create-role.sql create-user.sql create-schema.sql grant-access.sql  initial-data.sql | psql -d postgres -h localhost -p 5432 -U postgres 

