# Define base docker image
FROM openjdk:21
LABEL maintainer="maguda@fullscale.io"
ADD target/cms-0.0.1-SNAPSHOT.jar cms.jar
ENTRYPOINT ["java", "-jar", "/cms.jar"]

# Build docker image
# docker build -t cms:latest .

# Run MySQL image
# docker run --detach --env MYSQL_ROOT_PASSWORD=root-password --env MYSQL_USER=user --env MYSQL_PASSWORD=password --env MYSQL_DATABASE=contacts --name mysql --publish 3306:3306 mysql:8-oracle

# Run docker image
# docker run --name cms -p 8081:8080 cms:latest
