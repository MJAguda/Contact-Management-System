# Build the MySQL image
docker build -t mysql-image -f Dockerfile.mysql .

# Build the Spring Boot image
docker build -t springboot-app -f Dockerfile.springboot .

# Run MySQL Container
docker run -d --name mysql-container -p 3306:3306 mysql-image


# Run Spring Boot Container
docker run -d --name springboot-container -p 8080:8080 --link mysql-container:mysql springboot-app

