package Lesson_6.GUI.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Network {
    private DataInputStream DATA_INPUT_STREAM;
    private DataOutputStream DATA_OUTPUT_STREAM;
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8189;


    private Socket socketServer;
    private final String host;
    private final int port;


    public Network() {
        this(SERVER_HOST, SERVER_PORT);
    }

    public Network(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public boolean connect() {
        try {
            socketServer = new Socket(host, port);
            DATA_INPUT_STREAM = new DataInputStream(socketServer.getInputStream());
            DATA_OUTPUT_STREAM = new DataOutputStream(socketServer.getOutputStream());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Соединение не может быть установлено");
            return false;
        }
    }

    public void close() {
        try {
            socketServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DataInputStream getDATA_INPUT_STREAM() {
        return DATA_INPUT_STREAM;
    }

    public DataOutputStream getDATA_OUTPUT_STREAM() {
        return DATA_OUTPUT_STREAM;
    }
}
