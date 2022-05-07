# Account Microservice

## Setup
1. Execute `mvn clean install` on the root directory
2. Build docker image for `apigw`, `eureka-server`, `service-a` and `service-b` by executing `docker build -t <directory-name> .` on each directory
3. Go to the root directory and spin-up the services using `docker-compose up -d`

## How to run Integration Test

1. Run everything using `docker-compose up -d`
2. Go to apigw folder and execute `mvn clean verify`

## Preparing it in production
- To ensure our gateway is scalable we need to ensure it has at least 2 instances on different region with Auto Scaling enabled (with 60% CPU threshold)
- For monitoring we can use AWS Alarm or even integrating it with New Relic.
 
