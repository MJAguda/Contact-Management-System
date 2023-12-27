# # Base image: openjdk:21
# FROM openjdk:21
# LABEL maintainer="Mark Jayson Molina Aguda"
# ADD target/*.jar cms.jar
# ENTRYPOINT [ "java", "-jar", "cms.jar" ]

# FROM maven:3.8.5-openjdk-17 # for Java 17
FROM maven
LABEL maintainer="Mark Jayson Molina Aguda"
WORKDIR /cms
COPY . .
RUN mvn clean install
ADD target/*.jar cms.jar
ENTRYPOINT [ "java", "-jar", "cms.jar" ]
# CMD mvn spring-boot:run