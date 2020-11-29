package Lesson_6.Console_Client_Server.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Scanner scanner = new Scanner(System.in);
    private static DataInputStream dataInputStream;
    private static DataOutputStream dataOutputStream;

    public Client(Socket serverSocket) {
        try {
            dataInputStream = new DataInputStream(serverSocket.getInputStream());
            dataOutputStream = new DataOutputStream(serverSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Client(String host, int port) {
        try {
            Socket tempSocket = new Socket(host, port);
            dataInputStream = new DataInputStream(tempSocket.getInputStream());
            dataOutputStream = new DataOutputStream(tempSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        Thread tRead = new Thread(() -> readMessage());
        Thread rSend = new Thread(() -> sendMessage());
        tRead.start();
        rSend.start();
//        sendMessage();
//        readMessage();
    }

    private void sendMessage() {
        while (true) {
            String message;
            /*synchronized (this)*/ {
                message = scanner.nextLine();
            }
            try {
                dataOutputStream.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void readMessage() {
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
}

/*    private void sendMessage() {
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
    }
    private void readMessage() {
        new Thread(() -> {
            synchronized (this) {
                while (true) {
                    String message = null;
                    try {
                        message = dataInputStream.readUTF();
                        System.out.println(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).run();
    }*/

