#define base docker image
FROM openjdk:21
LABEL maintainer="Renish_gamdha"
ADD target/Husband4Hire_APIs-0.0.1-SNAPSHOT.jar Husband4Hire_APIs.jar
ENTRYPOINT ["java","-jar", "Husband4Hire_APIs.jar"]
