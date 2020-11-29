package Lesson_6.Console_Client_Server.ThreadIO;

import java.io.DataInputStream;
import java.io.IOException;

public class ThreadIn implements Runnable {
    DataInputStream dataInputStream;

    public ThreadIn(DataInputStream dataInputStream) {
        this.dataInputStream = dataInputStream;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = dataInputStream.readUTF();
                showMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
