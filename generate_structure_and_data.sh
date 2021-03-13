#!/bin/bash
start_dir=$PWD
db_project_path=$1/src/main/resources/db/

cd $db_project_path


export PGPASSWORD="docker"

dropdb -h localhost -p 5432 -U postgres  postgres
createdb -h localhost -p 5432 -U postgres  postgres
psql -U postgres -d postgres -h localhost -p 5432 -a -f init.sql

echo changeLogFile:dbchangelog.xml > liquibase.properties
echo url:  jdbc:postgresql://localhost/postgres >> liquibase.properties
echo username:  postgres >> liquibase.properties
echo password:  docker   >> liquibase.properties
echo classpath: $start_dir/lib/postgresql-42.2.9.jar  >> liquibase.properties

liquibase --overwriteOutputFile=true  --diffTypes=tables,functions,views,columns,indexes,foreignkeys,primarykeys,uniqueconstraints,data,storedprocedure,triggers,sequences --changeLogFile=./changelog/db.changelog-master.xml generateChangeLog

rm liquibase.properties

