# start with the base image containing java
FROM openjdk:23-jdk-slim

# who maintains the image
LABEL maintainer="rudrapratapg"

# I am telling docker that there is a jar inside target folder, copy it to the docker image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# docker runs this command to execute microservice
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]