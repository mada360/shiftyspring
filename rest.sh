#!/bin/bash

# For the love of god don't do this irl
AUTH='-H "Authorization: Basic YWRtaW46YWRtaW4xMjMh" '
HEADERS='-H "Accept:application/json" -H "Content-Type:application/json" ' 

HOST='http://localhost:8080/apiman/'
POST='curl -X POST '
PUT='curl -X PUT '
GET='curl -X GET '

# Add keycloak plugin
${POST} -H "Authorization: Basic YWRtaW46YWRtaW4xMjMh" -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8080/apiman/plugins -d '{"name":"Keycloak OAuth Policy Plugin", "artifactId":"apiman-plugins-keycloak-oauth-policy", "description":"This plugin offers an OAuth2 policy which leverages the Keycloak authentication platform as the identity and access provider.", "version":"1.2.9.Final", "groupId":"io.apiman.plugins"}'


# TODO Configure Keycloak


# Create shifty organisation
${POST} -H "Authorization: Basic YWRtaW46YWRtaW4xMjMh" -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8080/apiman/organizations -d '{"name":" shifty", "description":"shifty org"}'

# Create plans
# Gold
${POST} -H "Authorization: Basic YWRtaW46YWRtaW4xMjMh" -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8080/apiman/organizations/shifty/plans -d '{"name":"Gold","description":"Top Tier plan, unlimited use","initialVersion":"1.0"}'
${POST} -H "Authorization: Basic YWRtaW46YWRtaW4xMjMh" -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8080/apiman/organizations/shifty/plans -d '{"name":"Silver","description":"Mid Tier plan, for more requests","initialVersion":"1.0"}'
${POST} -H "Authorization: Basic YWRtaW46YWRtaW4xMjMh" -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8080/apiman/organizations/shifty/plans -d '{"name":"Bronze","description":"Bottom Tier plan, limited use","initialVersion":"1.0"}'

# Add policies
${POST} -H "Authorization: Basic YWRtaW46YWRtaW4xMjMh" -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8080/apiman/organizations/shifty/plans/Gold/versions/1.0/policies/ -d '{"configuration":"{\"limit\":50000,\"granularity\":\"Api\",\"period\":\"Day\"}", "definitionId":"RateLimitingPolicy"}'
${POST} -H "Authorization: Basic YWRtaW46YWRtaW4xMjMh" -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8080/apiman/organizations/shifty/plans/Silver/versions/1.0/policies/ -d '{"configuration":"{\"limit\":25000,\"granularity\":\"Api\",\"period\":\"Day\"}", "definitionId":"RateLimitingPolicy"}'
${POST} -H "Authorization: Basic YWRtaW46YWRtaW4xMjMh" -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8080/apiman/organizations/shifty/plans/Bronze/versions/1.0/policies/ -d '{"configuration":"{\"limit\":10000,\"granularity\":\"Api\",\"period\":\"Day\"}", "definitionId":"RateLimitingPolicy"}'


# Lock plans
${POST} -H "Authorization: Basic YWRtaW46YWRtaW4xMjMh" -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8080/apiman/actions -d '{"type":"lockPlan","entityId":"Gold","entityVersion":"1.0","organizationId":"shifty"}'
${POST} -H "Authorization: Basic YWRtaW46YWRtaW4xMjMh" -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8080/apiman/actions -d '{"type":"lockPlan","entityId":"Silver","entityVersion":"1.0","organizationId":"shifty"}'
${POST} -H "Authorization: Basic YWRtaW46YWRtaW4xMjMh" -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8080/apiman/actions -d '{"type":"lockPlan","entityId":"Bronze","entityVersion":"1.0","organizationId":"shifty"}'


# Create API
${POST} -H "Authorization: Basic YWRtaW46YWRtaW4xMjMh" -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8080/apiman/organizations/shifty/apis -d '{"name":"shifty", "description":"shifty shift API", "definitionUrl":"http://localhost:8080/shiftyspring/api/", "endpointContentType":"json", "definitionType":"None", "initialVersion":"1.0", "endpoint":"http://localhost:8080/shiftyspring/api/", "publicAPI":"true","plans": [ { "version":"1.0", "planId":"Gold"}, { "version":"1.0", "planId":"Silver" }, { "version":"1.0", "planId":"Bronze" } ], "endpointType":"rest"}'

# Publish API
${POST} -H "Authorization: Basic YWRtaW46YWRtaW4xMjMh" -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8080/apiman/actions -d '{"type":"publishAPI","entityId":"shifty","entityVersion":"1.0","organizationId":"shifty"}'


# Create client app
${POST} -H "Authorization: Basic YWRtaW46YWRtaW4xMjMh" -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8080/apiman/organizations/shifty/clients -d '{"name":"RestClient","description":"","initialVersion":"1.0"}'


# Register client
${POST} -H "Authorization: Basic YWRtaW46YWRtaW4xMjMh" -H "Accept:application/json" -H "Content-Type:application/json" http://localhost:8080/apiman/actions -d '{"type":"registerClient","entityId":"RestClient","entityVersion":"1.0","organizationId":"shifty"}'
