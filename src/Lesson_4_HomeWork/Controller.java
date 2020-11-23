package Lesson_4_HomeWork;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.shape.ObservableFaceArray;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Controller {
    private Stage primaryStage;



    @FXML
    private ListView<Text> chatWindow;

    @FXML
    private TextField textField;


/*    @FXML
    private void initialize() {
    }*/
    public void exit(){
        Platform.exit();
    }

public void setPrimaryStage(Stage primaryStage){
    this.primaryStage = primaryStage;
}


    public void addMessage(){
        Text message = new Text(textField.getText());
        message.setWrappingWidth(primaryStage.getWidth());
        if (message.getText().isBlank()){
            textField.clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка ввода");
            alert.setContentText("Нельзя отправлять пустое сообщение");
            alert.showAndWait();
        } else {
            chatWindow.getItems().add(message);
            textField.clear();
        }
    }




}
