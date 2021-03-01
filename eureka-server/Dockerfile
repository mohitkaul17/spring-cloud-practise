FROM fabric8/java-alpine-openjdk11-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8761 8787
ENV JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,address=*:8787,suspend=n"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=docker -jar /app.jar"]