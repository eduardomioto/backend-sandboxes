#/usr/bin/env/sh
#set -e
#components="axis cxf hibernate jackson java jersey jpa spring-batch spring-boot spring-boot-actuator spring-boot-websocket spring-cloud spring-data spring-jdbc spring-jms spring-mvc spring-security spring-social"
components="spring-batch spring-boot spring-boot-actuator spring-cloud spring-data spring-jdbc spring-jms spring-mvc spring-security spring-social"
cd "java-sandbox"
for component in $components
do
    echo "Testing component: $component"
    cd $component
    mvn clean install
	cd ..
done