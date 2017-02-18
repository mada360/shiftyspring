FROM jboss/wildfly
ADD ./target/shiftyspring-0.0.1-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
