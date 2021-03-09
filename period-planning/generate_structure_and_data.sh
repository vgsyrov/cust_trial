#!/bin/bash
liquibase --diffTypes=tables,functions,views,columns,indexes,foreignkeys,primarykeys,uniqueconstraints,data,storedprocedure,triggers,sequences --changeLogFile=period-planing_initial.xml generateChangeLog

