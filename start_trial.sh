#!/bin/bash

#total remove images and containers
#docker rm -vf $(docker ps -a -q)
#docker rmi -f $(docker images -a -q)


./build_java.sh
./run-docker-comp.sh
