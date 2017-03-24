#!/bin/sh
MAX_WAIT=180
DELAY=10
TOTAL_WAIT=0

mvn clean package


#until [ $TOTAL_WAIT -gt $MAX_WAIT ]
#do
	case "$(uname -s)" in

  	 Darwin)
    	   sudo docker-compose build && docker-compose up -d
     	;;

   	 Linux)
      	   sudo docker-compose build && docker-compose up -d
        ;;

   	 CYGWIN*|MINGW32*|MSYS*)
       	   docker-compose build && docker-compose up
     	;;


   	 *)
     	   echo 'other OS - please run docker commands manually' 
     	;;
	esac
#done

sleep 90

./rest.sh