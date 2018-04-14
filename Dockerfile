FROM openjdk:8-jre

MAINTAINER "Mad Stripes - Adidas"

ADD target/madstripes-0.0.1-SNAPSHOT.jar /opt/app.jar

CMD ["java", "-jar", "/opt/app.jar"]
