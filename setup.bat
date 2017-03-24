@echo off
echo =========================================================
echo Running Maven Package
echo =========================================================
call mvn clean package

echo =========================================================
echo Running Docker Scripts
echo =========================================================

docker-compose build
docker-compose up -d

TIMEOUT /T 120

echo =========================================================
echo Running APIMAN setup
echo =========================================================

rem Add keycloak plugin
curl -i -X POST -H \"Authorization: Basic YWRtaW46YWRtaW4xMjMh\" -H \"Accept:application/json\" -H \"Content-Type:application/json\" http://localhost:8080/apiman/plugins -d '{\"name\":\"Keycloak OAuth Policy Plugin\", \"artifactId\":\"apiman-plugins-keycloak-oauth-policy\", \"description\":\"This plugin offers an OAuth2 policy which leverages the Keycloak authentication platform as the identity and access provider.\", \"version\":\"1.2.9.Final\", \"groupId\":\"io.apiman.plugins\"}'


rem Create shifty organisation
curl -i -X POST -H \"Authorization: Basic YWRtaW46YWRtaW4xMjMh\" -H \"Accept:application/json\" -H \"Content-Type:application/json\" http://localhost:8080/apiman/organizations -d '{\"name\":\"shifty\", \"description\":\"shifty org\"}'





