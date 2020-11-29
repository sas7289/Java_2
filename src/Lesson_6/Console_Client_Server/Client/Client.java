package Lesson_6.Console_Client_Server.Client;

import Lesson_6.Console_Client_Server.ThreadIO.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private Scanner scanner = new Scanner(System.in);
    private static DataInputStream dataInputStream;
    private static DataOutputStream dataOutputStream;



    public Client(String host, int port) {
        try {
            connect(host, port);
        } catch (UnknownHostException unknownHostException) {
            System.out.println("Не удалось подключиться");
            unknownHostException.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ошибка подключения");
            e.printStackTrace();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Недопустимое значение порта");
        }
    }

    private void connect(String host, int port) throws IOException {
        Socket tempSocket = new Socket(host, port);
        System.out.println("Подключение установлено");
        dataInputStream = new DataInputStream(tempSocket.getInputStream());
        dataOutputStream = new DataOutputStream(tempSocket.getOutputStream());
    }

    public void start() {
        Thread tRead = new Thread(new ThreadIn(dataInputStream));
        Thread rSend = new Thread(new ThreadOut(dataOutputStream));
        tRead.start();
        rSend.start();
    }

}



