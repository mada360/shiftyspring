# Shifty

Shifty - A shift management API (Now with more springs)

## About


## Usage

### Running using [wildfly](http://wildfly.org) 
**Requires wildfly installation as well as postgres**

Run using the following command from the root directory `mvn wildfly:run`.

### Running using [Docker](https://www.docker)

**Requires Docker installation**

To run an instance of Shifty simply ensure that Docker is installed and from the root directory (the one with the Dockerfile) use the following command `sudo docker run -it -p 8080:8080 shifty`. If you would like to access port 8080 through a different local port, please change the first instance e.g.` -p 9000:8080`.

## To Do

-  [ ]  HATEOS API and domain model (20%) *in progress*
-  [ ]  Usability of HTML/Javascript frontend (20%)
-  [ ]  Authentication implementation e.g. [Keycloak](http://www.keycloak.org)(20%)
-  [x]  Persistence of data (20%)
-  [ ]  Completeness of automated tests of the business logic (20%)
