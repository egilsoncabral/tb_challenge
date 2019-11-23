FROM openjdk:8-alpine

MAINTAINER Egilson Cabral

RUN apk update && apk add bash

RUN mkdir -p /opt/app

ENV PROJECT_HOME /opt/app

COPY target/challenge-0.0.1-SNAPSHOT.jar $PROJECT_HOME/challenge-0.0.1-SNAPSHOT.jar

WORKDIR $PROJECT_HOME

CMD ["java", "-jar", "./challenge-0.0.1-SNAPSHOT.jar"]