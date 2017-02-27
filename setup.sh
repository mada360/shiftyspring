#!/bin/bash

if [ "$EUID" -ne 0 ]
  then echo "Please run as root"
  exit
fi

mvn clean package

sudo docker build --tag=shiftyspring .

sudo docker-compose up
