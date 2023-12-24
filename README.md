# Build docker image
# docker build -t cms:latest .

# Run docker image
# docker run --name cms -p 8081:8080 cms:latest

# docker run --detach 
# --env MYSQL_ROOT_PASSWORD=root-password
# --env MYSQL_USER=user
# --env MYSQL_PASSWORD=password
# --env MYSQL_DATABASE=contacts 

# --name mysql 
# --publish 3306:3306 mysql:8-oracle