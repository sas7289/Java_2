package Lesson_6.Console_Client_Server.Client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Socket serverSocket;
    static DataInputStream dataInputStream;
    static DataOutputStream dataOutputStream;
    public static void main(String[] args) {
        try {
            serverSocket = new Socket("localhost", 8189);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataInputStream = new DataInputStream(serverSocket.getInputStream());
            dataOutputStream = new DataOutputStream(serverSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            String message = scanner.nextLine();
            try {
                dataOutputStream.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
