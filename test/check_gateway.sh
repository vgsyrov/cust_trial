#!/bin/bash

./check_url.sh http://localhost:8080/ping
./check_url.sh http://localhost:8080/auto-attendance PUT BODY
./check_url.sh http://localhost:8080/eventResults/initialEvent_2