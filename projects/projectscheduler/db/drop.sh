#!/bin/sh
cat drop-*.sql | psql -d postgres -h localhost -p 5432 -U postgres

