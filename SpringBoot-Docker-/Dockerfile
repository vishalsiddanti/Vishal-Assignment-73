FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/Boot-Dockercf-Assign73-20Sep17-0.0.1-SNAPSHOT.jar boot-docker-73.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /boot-docker-73.jar" ]