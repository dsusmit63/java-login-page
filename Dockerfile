FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY Main.java Main.java
COPY login.html login.html

RUN javac Main.java

EXPOSE 8000

CMD ["java","Main"]
