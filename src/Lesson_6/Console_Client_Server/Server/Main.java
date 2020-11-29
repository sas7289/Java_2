package Lesson_6.Console_Client_Server.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    private static int server_port = 8189;
    private static ServerSocket serverSocket;
    public static void main(String[] args) {
        {
            try {
                serverSocket = new ServerSocket(server_port);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Server server = new Server(serverSocket);
            server.start();
        }

    }



}
