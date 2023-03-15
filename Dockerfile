# gradle
#FROM openjdk:11

#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

#manually
FROM openjdk:11

ARG JAR_FILE=build/libs/spring-boot-crud-operation-0.0.1.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]



#FROM jenkins/jenkins:lts
#USER root
#RUN apt-get update -qq \
#    && apt-get install -qqy apt-transport-https ca-certificates curl gnupg2 software-properties-common
#RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
#RUN add-apt-repository \
#   "deb [arch=amd64] https://download.docker.com/linux/debian \
#   $(lsb_release -cs) \
#   stable"
#RUN apt-get update  -qq \
#    && apt-get -y install docker-ce
#RUN usermod -aG docker jenkins

#ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
