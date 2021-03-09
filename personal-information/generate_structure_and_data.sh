#!/bin/bash
liquibase --diffTypes=tables,functions,views,columns,indexes,foreignkeys,primarykeys,uniqueconstraints,data,storedprocedure,triggers,sequences --changeLogFile=personal_information_initial.xml generateChangeLog

