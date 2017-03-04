ECHO Cleaning and generating war file.

RUN mvn clean package


ECHO Building Shifty from Dockerfile

docker build --tag=shiftyspring .


ECHO Starting Shifty + Postgresql

docker-compose up
