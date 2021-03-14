#!/bin/bash

#docker-compose rm -f
#docker-compose pull
docker-compose -f docker-compose_full.yml up --build --no-color > docker.log