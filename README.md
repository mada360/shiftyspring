# Shifty

## About
[![Build Status](https://travis-ci.org/mada360/shiftyspring.svg?branch=master)](https://travis-ci.org/mada360/shiftyspring)
[![Coverage Status](https://coveralls.io/repos/github/mada360/shiftyspring/badge.svg?branch=master)](https://coveralls.io/github/mada360/shiftyspring?branch=master)

## Usage
**Requires Docker installation**

To run an instance of Shifty simply ensure that Docker is installed and from the root directory (the one with the Dockerfile) use the following command `./setup.sh`. Docker requires sudo privileges and will request the sudo password.

The setup process may take some time, feel free to grab a coffee, you earned it!

Once running the shifty api will be accessible though [localhost:8080/shiftyspring/api](http://localhost:8080/shiftyspring/api).

### Windows

To run on windows please consider using [cygwin](https://www.cygwin.com), [babun](https://babun.github.io) or similar command line environment and run the setup.sh script; unlike in Linux or OSX there is no need to provide sudo permissions.

Alternatively the commands can be run manually in the command line or powershell as shown below:

```
PS C:\git\shiftyspring> mvn clean package
PS C:\git\shiftyspring> docker-compose build
PS C:\git\shiftyspring> docker-compose up
```

## To Do

-  [x]  HATEOS API and domain model (20%)
-  [x]  Usability of HTML/Javascript front-end (20%)
-  [ ]  Authentication implementation e.g. [Keycloak](http://www.keycloak.org)(10%)
-  [x]  API Limiting and policies using [APIman]() (10%)
-  [x]  Persistence of data (20%)
-  [ ]  Completeness of automated tests of the business logic (20%)
-  [x]  Automation of deployment: Bash script

 Current completion 70% 