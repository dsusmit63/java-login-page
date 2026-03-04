# Java Login Page
A lightweight Java HTTP server application that serves a simple login page and validates credentials via a backend API.

## Features

- Running a Java HTTP server without frameworks

- Serving static HTML UI

- Handling POST login requests

- Containerizing a Java application using Docker

The application runs on port 8000.

## Project Structure

```bash
java-login-page
│
├── Main.java        
├── login.html       
├── Dockerfile       
└── README.md
```
## Running the Application

### Running Locally
1. Clone the Repository:
```bash
git clone https://github.com/dsusmit63/simple-java-docker.git
cd simple-java-docker
```
2. Compile and run the application:
```bash
javac src/Main.java -d out
java -cp out Main
```
3. The server will start on http://localhost:8000

### Build & Run with Docker
1. Clone the Repository:
```bash
git clone https://github.com/dsusmit63/java-login-page.git
cd java-login-page
```
2. Build the docker image:
 ```bash
docker build -t java-login-page:latest .
```
3. Run the container:
 ```bash
docker run -d -p 8000:8000 --name java-login-page java-login-page:latest
```
4. Access the application at  http://localhost:8000

## Author

Susmit Das
https://github.com/dsusmit63



