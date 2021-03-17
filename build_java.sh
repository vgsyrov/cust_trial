#!/bin/bash

cd academic-performance
mvn -DskipTests=true install
cd ..

cd period-planning
mvn -DskipTests=true install
cd ..

cd personal-information
mvn -DskipTests=true install
cd ..

cd schedule-calendar
mvn -DskipTests=true install
cd ..

cd results-control-api-gateway
mvn -DskipTests=true install
cd ..
