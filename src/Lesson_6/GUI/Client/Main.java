package Lesson_6.GUI.Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static final String clientFXML = "sample.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(clientFXML));
        Parent root = loader.load();
        primaryStage.setTitle("ClientWindow");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


        Network server = new Network();
        if(!server.connect()) {
            System.out.println("Ошибка подключения к серверу");
        }

        Controller controller = loader.getController();
        controller.setNetwork(server);
        controller.setStageWidth(primaryStage.getWidth());

        primaryStage.setOnCloseRequest(windowEvent -> server.close());



    }

    public static void main(String[] args) {
        launch(args);
    }
}
