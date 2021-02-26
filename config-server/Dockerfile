FROM adoptopenjdk/openjdk11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8888 8787
ENV JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,address=*:8787,suspend=n"
#ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /app.jar"]
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]
