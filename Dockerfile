FROM fishead/docker-tomcat-maven:latest

RUN mkdir /app

COPY . /app/

WORKDIR /app

RUN mvn clean package -Dmaven.test.skip=true

RUN rm -rf /usr/local/tomcat/webapps/*

RUN cp  /app/target/hellodocker.war  /usr/local/tomcat/webapps

