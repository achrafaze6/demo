FROM maven:3.9.5 AS build
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency: resolve
COPY . /app
RUN mvn clean
RUN mvn package -DskipTests -X

FROM openjdk:17-alpine
ENV PORT 8080
EXPOSE 8080
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar