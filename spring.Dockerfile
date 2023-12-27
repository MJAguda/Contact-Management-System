# Base image: openjdk:21
FROM openjdk:21
LABEL maintainer="Mark Jayson Molina Aguda"
ADD target/*.jar cms.jar
ENTRYPOINT [ "java", "-jar", "cms.jar" ]