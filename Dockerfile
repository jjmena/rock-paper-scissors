FROM openjdk:8-jre

ADD target/${JAR_FILE} /usr/share/myservice/${JAR_FILE}
ENTRYPOINT ["java", "-jar", "/usr/share/myservice/rock-paper-scissors-0.0.1-SNAPSHOT.jar"]

