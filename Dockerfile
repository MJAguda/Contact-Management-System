# Define base docker image
FROM openjdk:21.04-jdk-slim-buster
LABEL maintainer="maguda@fullscale.io"

# Add the application's jar file to the container
ADD target/cms-0.0.1-SNAPSHOT.jar cms.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/cms.jar"]