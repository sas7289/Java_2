package Lesson_6.Console_Client_Server.Server;

import Lesson_6.Console_Client_Server.ThreadIO.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    Scanner scanner;

    private static int server_port;

    private ServerSocket serverSocket;
    protected static DataOutputStream dataOutputStream;
    protected static DataInputStream dataInputStream;

    private final int SERVER_PORT = 8189;

    public Server() {
        server_port = SERVER_PORT;
        try {
            serverSocket = new ServerSocket(server_port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Server(int serverPort) {
        server_port = serverPort;
        try {
            serverSocket = new ServerSocket(server_port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void start() {
        try {
            connect();
        } catch (IOException e) {
            System.out.println("Ошибка передачи данных");
            e.printStackTrace();
        }
        Thread threadO = new Thread(new ThreadOut(dataOutputStream));
        Thread threadI = new Thread(new ThreadIn(dataInputStream));
        threadO.start();
        threadI.start();
    }

    private void connect() throws IOException {
        System.out.println("Ожидание подключения...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Подключение установлено");
        dataInputStream = new DataInputStream(clientSocket.getInputStream());
        dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
    }


}



