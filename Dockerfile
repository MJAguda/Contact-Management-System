FROM maven:3.8.6-openjdk-18-slim AS build
WORKDIR /home/app
COPY . /home/app/
RUN mvn -f /home/app/pom.xml clean package

# Define base docker image
FROM openjdk:18.0-slim
LABEL maintainer="maguda@fullscale.io"
VOLUME /tmp
EXPOSE 8080
COPY --from=build /home/app/target/*.jar cms.jar

ENTRYPOINT ["sh", "-c", "java -jar /cms.jar"]
