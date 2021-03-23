#!/bin/bash

#total remove images and containers
#docker rm -vf $(docker ps -a -q)
#docker rmi -f $(docker images -a -q)

#./build_java.sh
docker-compose -f docker-compose_full.yml build --parallel #--no-color > docker.log
docker-compose -f docker-compose_full.yml up --quiet-pull #--build #--no-color > docker.log
