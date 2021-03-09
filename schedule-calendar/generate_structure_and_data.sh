#!/bin/bash
liquibase --diffTypes=tables,functions,views,columns,indexes,foreignkeys,primarykeys,uniqueconstraints,data,storedprocedure,triggers,sequences --changeLogFile=schedule-calendar_initial.xml generateChangeLog

