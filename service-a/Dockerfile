FROM openjdk:17-jdk-slim-buster
EXPOSE 8081
ADD /target/service-a-1.0.jar service-a-1.0.jar
ENTRYPOINT ["java","-jar","service-a-1.0.jar"]
