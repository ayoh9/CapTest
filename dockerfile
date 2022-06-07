FROM openjdk:11-jre-slim

ENV JAVA_OPTS " -Xms512m -Xms512m -Djava.security.egd=file:/dev/./urandom"

WORKDIR application

EXPOSE 8080

COPY ./target/captest-0.0.1-SNAPSHOT.jar ./

ENTRYPOINT ["java","-jar","captest-0.0.1-SNAPSHOT.jar"]