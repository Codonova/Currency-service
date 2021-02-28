FROM openjdk:8-alpine3.9
#
ARG PROJECT_NAME=сurrency-service
ENV PROJECT_NAME=${PROJECT_NAME}
ARG GIT_COMMIT=unknown
ENV GIT_COMMIT=${GIT_COMMIT}
###
COPY build/libs/${PROJECT_NAME}*.jar /opt/${PROJECT_NAME}.jar

EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/opt/сurrency-service.jar"]