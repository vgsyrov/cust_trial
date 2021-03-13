#!/bin/bash
start_dir=$PWD
db_project_path=$1/src/main/resources/db/

cd $db_project_path


export PGPASSWORD="docker"

dropdb -h localhost -p 5432 -U postgres  postgres
createdb -h localhost -p 5432 -U postgres  postgres
psql -U postgres -d postgres -h localhost -p 5432 -a -f init.sql

liquibase --defaultsFile=$start_dir/liquibase.properties --overwriteOutputFile=true  --diffTypes=tables,functions,views,columns,indexes,foreignkeys,primarykeys,uniqueconstraints,data,storedprocedure,triggers,sequences --changeLogFile=$db_project_path/changelog/db.changelog-master.xml generateChangeLog

