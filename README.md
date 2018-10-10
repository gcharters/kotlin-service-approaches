# kotlin-service-approaches
Different ways to do server-side services in Kotlin

Examples cover Spring Boot, Ktor and JAX-RS

Each example provide the same API

GET localhost:8080/greeting returns a 405 with an message

GET localhost:8080/greeting/{name} 
```JSON
{
  "name": "{name}",
  "message": "Hello"
}
```
POST localhost:8080/greeting with body
```JSON
{
  "name": "Name",
  "message": "Bonjour"
}
```
Changes the greeting message to 'Bonjour'

Each demo is designed to be built separately.

## Spring

```
cd spring
./mvnw clean install
java -jar target/spring-0.0.1-SNAPSHOT.jar
```

## Ktor

```
cd ktor
./gradlew :run
```

## Java EE

```
cd javaee
mvn clean install
java -jar target/kotlinHello.jar
```

