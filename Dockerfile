FROM tomcat:latest
RUN rm -rf /usr/local/tomcat/webapps/*
copy  target/hellodocker.war  /usr/local/tomcat/webapps
