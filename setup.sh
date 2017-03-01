#!/bin/bash

mvn clean package

sudo docker build --tag=shiftyspring .

sudo docker run -it -p 8080:8080 shiftyspring
