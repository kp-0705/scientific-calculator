FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY target/scientific-calculator-1.0-SNAPSHOT.jar calculator.jar

CMD ["java", "-jar", "calculator.jar"]
