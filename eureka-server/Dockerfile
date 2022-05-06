FROM adoptopenjdk/openjdk11:latest
EXPOSE 8761
ADD /target/eureka-server-1.0.jar eureka-server-1.0.jar
ENTRYPOINT ["java","-jar","eureka-server-1.0.jar"]
