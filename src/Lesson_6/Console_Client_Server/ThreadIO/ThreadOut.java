package Lesson_6.Console_Client_Server.ThreadIO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ThreadOut implements Runnable {
    Scanner scanner = new Scanner(System.in);

    DataOutputStream dataOutputStream;

    public ThreadOut(DataOutputStream dataOutputStream) {
        this.dataOutputStream = dataOutputStream;
    }

    @Override
    public void run() {
        while (true) {
            String message = scanner.nextLine();
            if (exit(message)) {
                break;
            }
            sendMessage(message);
        }
    }

    public void sendMessage(String message) {
        try {
            dataOutputStream.writeUTF(message);
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
