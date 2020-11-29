package Lesson_6.Console_Client_Server.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server /*implements *//*Runnable*//* */{
    protected boolean suspendFlag = true;
    Scanner scanner;

    private static int server_port = 8189;

//    protected Thread thread;
    private ServerSocket serverSocket;
    protected static DataOutputStream dataOutputStream;
    protected static DataInputStream dataInputStream;

    protected Server(ServerSocket serverSocket) {
        scanner = new Scanner(System.in);
        this.serverSocket = serverSocket;
//        thread = new Thread(this);
//        thread.run();
    }

    protected Server getThisServer() {
        return this;
    }


    public void start() {
        try {
            System.out.println("Ожидание подключения...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Подключение установлено");
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread tRead = new Thread(() -> readMessage());
        Thread rSend = new Thread(() -> sendMessage());
        tRead.start();
        rSend.start();
    }

    public void readMessage() {
        while (true) {
            try {
                String message = dataInputStream.readUTF();
                /*synchronized (this) */{
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /*synchronized*/
    public void sendMessage() {
        while (true) {
            String message;
            /*synchronized (this) */{
                message = scanner.nextLine();
            }
            try {
                dataOutputStream.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

    /*public void readMessage() {
        new Thread(() -> {
            synchronized (this) {
                while (true) {
                    try {
                        String message = dataInputStream.readUTF();
                        System.out.println(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).run();
    }
    *//*synchronized*//* public void sendMessage() {
        new Thread(() -> {
            synchronized (this) {
                while (true) {
                    String message = scanner.nextLine();
                    try {
                        dataOutputStream.writeUTF(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).run();
    }*/

