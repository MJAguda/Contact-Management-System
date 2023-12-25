<!-- Pull MySQL Image -->
docker pull mysql

<!-- Run Docker Container -->
docker run -p 3307:3306 --name mysqlcontainer -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=contacts -d mysql

<!-- Create network -->
docker network create networkmysql

<!-- Connect network -->
docker network connect networkmysql mysqlcontainer

<!-- Build Spring Boot Application Image -->
docker build -t cmsimage .

<!-- Run Spring Boot Application Container -->
docker run -p 8090:8080 --name cmscontainer --net networkmysql -e MYSQL_HOST=mysqlcontainer -e MYSQL_PORT:3306 -e MYSQL_DB_NAME=contacts -e MYSQL_USER=root -e MYSQL_PASSWORD:root cmsimage