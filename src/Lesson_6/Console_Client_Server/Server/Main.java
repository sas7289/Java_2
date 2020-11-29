package Lesson_6.Console_Client_Server.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    private static int server_port = 8189;

    public static void main(String[] args) {
        {
            Server server = new Server();
            server.start();
        }
    }
}
