package Lesson_6.GUI.Client;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.io.IOException;


public class Controller {
    @FXML
    private ListView<String> listMembers;

    @FXML
    private ListView<String> allMessagesList;

    @FXML
    private TextArea messageField;

    private Network network;
    private double stageWidth;

    public void setStageWidth(double stageWidth) {
        this.stageWidth = stageWidth;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

/*    public void addText(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            String message = messageField.getText();
            sendMessageToServer(message);
            messageField.clear();
        }
    }*/

    public void addMessage() {
        String message = messageField.getText();
        sendMessageToServer(message);
        messageField.clear();
    }

    private void sendMessageToServer(String message) {
        try {
            network.getDATA_OUTPUT_STREAM().writeUTF(message);
            Text textMessage = new Text(message);
            textMessage.setWrappingWidth(stageWidth);
            allMessagesList.getItems().add(textMessage.getText());
            textMessage = new Text(network.getDATA_INPUT_STREAM().readUTF());
            allMessagesList.getItems().add(textMessage.getText());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при отправке сообщения");
        }
    }

}
