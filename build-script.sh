#/usr/bin/env/sh
components="spring-batch spring-boot spring-boot-actuator spring-cloud spring-data spring-jdbc spring-jms spring-mvc spring-security spring-social"
cd "java-sandbox"
for component in $components
do
    echo "Testing component: $component"
    cd $component
    mvn clean install
	cd ..
done