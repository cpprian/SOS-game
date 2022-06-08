package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.ResourceBundle;

public class Enter extends Application {
    @FXML
    private Label sosGameText;
    @FXML
    private TextField mapSize;
    @FXML
    private Button enterButton;
    private static int map;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("enter.fxml")));
        root.getStylesheets().add(String.valueOf(
                Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm()));
        primaryStage.setTitle("SOS game");
        primaryStage.setScene(new Scene(root));
        primaryStage.setWidth(700);
        primaryStage.setHeight(570);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void enterGame(ActionEvent actionEvent) {
        enterButton.setOnMouseClicked(e -> {
            try {
                map = Integer.parseInt(mapSize.getText());
                if (map >= 3 && map <= 9) {
                    mapSize.setPromptText("Rozmiar planszy musi być z przedziału <3, 10>");
                }

                initGame(actionEvent);
            } catch (Exception ex) {
                mapSize.setPromptText("Rozmiar planszy musi być z przedziału <3, 10>");
            }
        });
    }

    @FXML
    protected void initGame(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game.fxml")));
        root.getStylesheets().add(String.valueOf(
                Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm()));
        Scene scene = new Scene(root,570, 700);
        scene.setFill(Color.BLACK);
        Stage gameStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        gameStage.setScene(scene);
        gameStage.show();
        gameStage.centerOnScreen();
    }

    public static void setMap(int m) {
        map = m;
    }

    public static int getMap() {
        return map;
    }
}
