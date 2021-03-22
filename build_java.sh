#!/bin/bash

#docker volume create --name maven-repo
# docker run -it -v maven-repo:/root/.m2 maven mvn archetype:generate # will download artifacts
#$ docker run -it -v maven-repo:/root/.m2 maven mvn archetype:generate # will reuse downloaded artifacts

cd academic-performance
#mvn -DskipTests=true install
../build_java_project_in_docker_image.sh
cd ..

cd period-planning
#mvn -DskipTests=true install
../build_java_project_in_docker_image.sh
cd ..

cd personal-information
#mvn -DskipTests=true install
../build_java_project_in_docker_image.sh
cd ..

cd schedule-calendar
#mvn -DskipTests=true install
../build_java_project_in_docker_image.sh
cd ..

cd results-control-api-gateway
#mvn install
../build_java_project_in_docker_image.sh TEST
cd ..
