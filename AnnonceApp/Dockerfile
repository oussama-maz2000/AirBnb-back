FROM openjdk:17-oracle

MAINTAINER DARKOUM <darkoum.teams@darkoum.com>

WORKDIR /opt

ADD target/*.jar app.jar

ENTRYPOINT ["java","-jar","/opt/app.jar"]