# Define base docker image
FROM openjdk:11
LABEL maintainer="maguda@fullscale.io"

# Copy entire project to Docker image
COPY . /app

# Set working directory
WORKDIR /app

# Grant permissions for the mvnw script to be executable
RUN chmod +x ./mvnw

# Run Maven Wrapper command
RUN ./mvnw clean package

# Add the application's jar file to the container
ADD target/cms-0.0.1-SNAPSHOT.jar cms.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/cms.jar"]