FROM openjdk:17-jdk-slim-buster
EXPOSE 8082
ADD /target/service-b-1.0.jar service-b-1.0.jar
ENTRYPOINT ["java","-jar","service-b-1.0.jar"]
