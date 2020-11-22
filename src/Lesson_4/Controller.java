package Lesson_4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.sql.rowset.spi.SyncResolver;


public class Controller {
    @FXML
    private TextField inputField;

    @FXML
    private ListView <String> listView;

    @FXML
    private TableView<RowWord> tableView;

    @FXML
    private TableColumn<RowWord, String> wordTableColumn;

    @FXML
    private TableColumn<RowWord, Integer> countTableColumn;

    public final ObservableList<RowWord> frequencyWord = FXCollections.observableArrayList(
            new RowWord("a", 1),
            new RowWord("b", 2),
            new RowWord("c", 3)
    );

    private final ObservableList<String> wordList = FXCollections.observableArrayList("Привет","Часы","Новый год!");

    @FXML
    public void initialize(){
        wordTableColumn.setCellValueFactory(new PropertyValueFactory<>("word"));
        countTableColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
        listView.setItems(wordList);
        tableView.setItems(frequencyWord);
    }


    @FXML
    public void addWord(){
        String word = inputField.getText();
        if (!word.isBlank()){
            addWordToList(word);
            addWordToTable(word);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("InputError");
            alert.setHeaderText("Ошибка ввода сообщения");
            alert.setContentText("ALARM! EMPTY ROW!");
            alert.showAndWait();
            return;
        }
        inputField.clear();
    }

    @FXML
    public void showAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Lesson 4");
        alert.setContentText("Приложение 4го занятия");
        alert.showAndWait();
        return;
    }

    private void addWordToTable(String word) {
        for (RowWord rowWord : frequencyWord) {
            if (word.equals(rowWord.getWord())){
                rowWord.incCount();
                return;
            }
        }
        frequencyWord.add(new RowWord(word, 1));
    }

    @FXML
    public void exit () {
        System.exit(1);
    }

    private void addWordToList(String word) {
        listView.getItems().add(word);
    }
}
