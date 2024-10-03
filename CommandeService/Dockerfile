FROM openjdk:17-jdk-slim
WORKDIR  /app

COPY target/CommandeService-0.0.1-SNAPSHOT.jar CommandeService.jar

EXPOSE 8082

CMD ["java","-jar","CommandeService.jar"]