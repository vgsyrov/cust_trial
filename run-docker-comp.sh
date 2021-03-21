#!/bin/bash

#docker-compose rm -f docker-compose_full.yml
#docker-compose pull -f docker-compose_full.yml

docker-compose -f docker-compose_full.yml up --abort-on-container-exit --quiet-pull --build #--no-color > docker.log