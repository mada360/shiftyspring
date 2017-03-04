#!/bin/bash

mvn clean package

docker build --tag=shiftyspring .

docker-compose up
