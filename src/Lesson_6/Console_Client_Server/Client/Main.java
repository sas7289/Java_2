package Lesson_6.Console_Client_Server.Client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("localhost", 8189);
        client.start();
    }



}
