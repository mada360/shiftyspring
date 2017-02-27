FROM jboss/keycloak-adapter-wildfly
ADD target/shiftyspring.war /opt/jboss/wildfly/standalone/deployments/
