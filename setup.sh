#!/bin/sh

mvn clean package

case "$(uname -s)" in

   Darwin)
       sudo docker-compose build && docker-compose up
     ;;

   Linux)
       sudo docker-compose build && docker-compose up
     ;;

   CYGWIN*|MINGW32*|MSYS*)
       docker-compose build && docker-compose up
     ;;


   *)
     echo 'other OS - please run docker commands manually' 
     ;;
esac
