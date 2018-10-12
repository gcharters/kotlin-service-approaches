# Kotlin Service Approaches

Different ways to do server-side services in Kotlin

Examples cover Spring Boot, Ktor and JAX-RS

## API

Each example provides the same API

GET http://localhost:8080/greeting returns a 405 with a message

GET http://localhost:8080/greeting/{name} 
```JSON
{
  "name": "{name}",
  "message": "Hello"
}

```
POST http://localhost:8080/greeting with body
```JSON
{
  "name": "Name",
  "message": "Bonjour"
}
```

Changes the greeting message to 'Bonjour', the name is ignored.

## Build & Run

Each demo is designed to be built separately.

### Spring

```
cd spring
./mvnw clean install
java -jar target/spring-0.0.1-SNAPSHOT.jar
```

### Ktor

```
cd ktor
./gradlew :run
```

### JAX-RS (Java EE)

```
cd javaee
mvn clean install
java -jar target/kotlinHello.jar
```

