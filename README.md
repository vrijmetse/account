# Account Microservice

## Setup
1. Execute `mvn clean install` on the root directory
2. Build docker image for `apigw`, `eureka-server`, `service-a` and `service-b` by executing `docker build -t <directory-name> .` on each directory
3. Go to the root directory and spin-up the services using `docker-compose up -d`

## How to run Integration Test

1. Run everything using `docker-compose up -d`
2. Go to apigw folder and execute `mvn clean verify`
 
