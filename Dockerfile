FROM openjdk:8-jre

MAINTAINER "Mad Stripes Backend - Adidas"

ADD target/backend-0.0.1-SNAPSHOT.jar /opt/app.jar

CMD ["java", "-jar", "-Dspring.profiles.active=docker", "/opt/app.jar"]
