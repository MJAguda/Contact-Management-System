# Build docker image
docker build -t cms:latest .

# Run MySQL image
docker run --detach --env MYSQL_ROOT_PASSWORD=root-password --env MYSQL_USER=user --env MYSQL_PASSWORD=password --env MYSQL_DATABASE=contacts --name mysql --publish 3306:3306 mysql:8-oracle

# Run docker image
docker run --name cms -p 8081:8080 cms:latest

<!--  -->

# Build the MySQL image
docker build -t my-mysql-image -f Dockerfile.mysql .

# Build the Spring Boot image
docker build -t my-springboot-app -f Dockerfile.springboot .

# Run MySQL Container
docker run -d --name my-mysql-container -p 3306:3306 my-mysql-image

# Run Spring Boot Container
docker run -d --name my-springboot-container -p 8080:8080 --link my-mysql-container:mysql my-springboot-app


