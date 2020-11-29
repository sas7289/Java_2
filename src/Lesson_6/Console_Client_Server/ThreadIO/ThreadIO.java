package Lesson_6.Console_Client_Server.ThreadIO;

import javafx.scene.shape.Box;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ThreadIO {
    Boolean exitFlag = false;
    Scanner scanner = new Scanner(System.in);
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    public ThreadIO(Socket socket) {
        try {
            this.socket = socket;
            this.dataInputStream = new DataInputStream(socket.getInputStream());
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            readMessage();
        }).start();
        new Thread(() -> {
            sendMessage();
        }).start();
    }


    public void readMessage() {
        while (!exitFlag) {
            try {
                String message = dataInputStream.readUTF();
                if (exit(message)) {
                    try {
                        socket.shutdownInput();
                        socket.shutdownOutput();
                        dataOutputStream.close();
                        exitFlag = true;
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                showMessage(message);
            } catch (EOFException eofException) {
                System.out.println("Передача прервана");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Приём окончен");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void sendMessage() {
        while (!exitFlag) {
            String message = scanner.nextLine();
            if (exit(message)) {
                try {
                    getOutMessage(message);
                    socket.shutdownInput();
                    socket.shutdownOutput();
                    exitFlag = true;
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            getOutMessage(message);
        }
        System.out.println("Передача окончена");
    }

    public void getOutMessage(String message) {
        try {
            dataOutputStream.writeUTF(message);
        } catch (SocketException socketException) {
            System.out.println("Соединение закрыто");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean exit(String message) {
        message.toLowerCase();
        if (message.equals("/exit") || message.equals("exit") || message.equals("e") || message.equals("/e")) {
            return true;
        } else {
            return false;
        }


    }
}