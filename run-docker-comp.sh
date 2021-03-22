#!/bin/bash

#docker-compose rm -f docker-compose_full.yml
#docker-compose pull -f docker-compose_full.yml
#--abort-on-container-exit

docker-compose -f docker-compose_full.yml up --quiet-pull --build #--no-color > docker.log