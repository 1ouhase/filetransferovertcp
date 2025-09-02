package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    Boolean running = true;

    public Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(6969);
        System.out.println("Server started on port 6969");

        while(running){
            System.out.println("Waiting for connection...");
            Socket socket = serverSocket.accept();

            System.out.println("Connection accepted");
            System.out.println("starting thread...");
            Thread serverThread = new Thread(socket, this);
            java.lang.Thread thread = new java.lang.Thread(serverThread);
            thread.start();
            System.out.println("thread started");
        }
        serverSocket.close();
    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
