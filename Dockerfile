FROM apiman/on-wildfly10 
ADD ./target/shiftyspring.war /opt/jboss/wildfly/standalone/deployments/
