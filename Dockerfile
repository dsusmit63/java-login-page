# BASE IMAGE
FROM eclipse-temurin:21-jdk-jammy

# WORKDIR
WORKDIR /app

# COPY CODE
COPY Main.java Main.java
COPY login.html login.html

# COMPILE
RUN javac Main.java

# EXPOSE PORT
EXPOSE 8000

# RUN & SERVE APPLICATION
CMD ["java","Main"]
