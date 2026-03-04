import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws Exception {

        int port = 8000;

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", new LoginHandler());
        server.createContext("/login", new LoginApiHandler());

        server.setExecutor(null);

        System.out.println("Server running on http://0.0.0.0:" + port);

        server.start();
    }

    static class LoginHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            File file = new File("login.html");

            if (!file.exists()) {

                String response = "login.html not found";

                exchange.sendResponseHeaders(500, response.length());

                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();

                return;
            }

            byte[] html = java.nio.file.Files.readAllBytes(file.toPath());

            exchange.getResponseHeaders().add("Content-Type", "text/html");

            exchange.sendResponseHeaders(200, html.length);

            OutputStream os = exchange.getResponseBody();
            os.write(html);
            os.close();
        }
    }

    static class LoginApiHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            if (!exchange.getRequestMethod().equalsIgnoreCase("POST")) {
                exchange.sendResponseHeaders(405, -1);
                return;
            }

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(exchange.getRequestBody())
            );

            StringBuilder body = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                body.append(line);
            }

            String response;

            if (body.toString().contains("admin") && body.toString().contains("password")) {
                response = "Login Successful 🚀";
            } else {
                response = "Invalid Credentials ❌";
            }

            exchange.getResponseHeaders().add("Content-Type", "text/plain");

            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
