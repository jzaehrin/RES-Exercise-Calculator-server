package ch.heigvd.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int listenPort = 2205;

    public void start() {
        System.out.println("Starting server...");

        // Message
        HelloMessage helloMessage = new HelloMessage(Operation.values());

        Calculator calculator = new Calculator(Operation.values());
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            System.out.println("Listen port 2205...");

            serverSocket = new ServerSocket(listenPort, 50, InetAddress.getLocalHost());

            while(true) {
                System.out.println("Waiting client...");
                clientSocket = serverSocket.accept();
                System.out.println("Accepted client...");

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());

                writer.write(helloMessage.toString());
                writer.flush();

                while(true) {
                    System.out.println("Wainting request");
                    String data = reader.readLine();

                    if (data == null) {
                        writer.close();
                        reader.close();
                        break;
                    }

                    if (data.contains("REQUEST")) {
                        writer.println(calculator.execute(data));
                        writer.flush();

                    } else if (data.contains("BYE")) {
                        System.out.println("BYE recived...");

                        writer.close();
                        reader.close();
                        clientSocket.close();
                        break;
                    } else {
                        writer.write(ErrorMessage.getErrorMessage("UNKNOWN request for " + data.substring(0, data.indexOf('\t'))));
                        writer.flush();
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void main(String[] args) {
        Server server = new Server();

        server.start();
    }
}
