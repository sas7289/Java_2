package Lesson_6.Console_Client_Server.Client;




public class Main {
    public static void main(String[] args) {
        Client client = new Client("localhost", 8189);
        client.start();
    }
}
