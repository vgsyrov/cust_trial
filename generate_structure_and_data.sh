#!/bin/bash
cd $1

export PGPASSWORD="docker"

dropdb -h localhost -p 5432 -U postgres  postgres
createdb -h localhost -p 5432 -U postgres  postgres
psql -U postgres -d postgres -h localhost -p 5432 -a -f $1.sql

liquibase --overwriteOutputFile=true  --diffTypes=tables,functions,views,columns,indexes,foreignkeys,primarykeys,uniqueconstraints,data,storedprocedure,triggers,sequences --changeLogFile=db.changelog-master.xml generateChangeLog

