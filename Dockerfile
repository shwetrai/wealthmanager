 FROM openjdk:17
 MAINTAINER ecosystem
 RUN mkdir /app
 WORKDIR /app
 COPY /target/wealthmanager-0.0.1-SNAPSHOT.jar  wealthmanagerapi.jar
 COPY /target/classes/application.properties application.properties
 CMD java -jar wealthmanagerapi.jar
