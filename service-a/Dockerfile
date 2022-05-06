FROM adoptopenjdk/openjdk11:latest
EXPOSE 8081
ADD /target/service-a-1.0.jar service-a-1.0.jar
ENTRYPOINT ["java","-jar","service-a-1.0.jar"]
