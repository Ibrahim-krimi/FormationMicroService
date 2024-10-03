FROM openjdk:17-jdk-slim

WORKDIR /app

COPY /target/ProduitService-0.0.1-SNAPSHOT.jar ProduitService.jar

EXPOSE 8081

CMD ["java","-jar","ProduitService.jar"]