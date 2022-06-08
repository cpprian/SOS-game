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
        primaryStage.setWidth(600);
        primaryStage.setHeight(500);
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
                if (map > 10 || map < 3) {
                    mapSize.setText("Rozmiar planszy musi być z przedziału <3, 10>");
                }

                initGame(actionEvent);
            } catch (Exception ex) {
                mapSize.setText("Rozmiar planszy musi być z przedziału <3, 10>");
            }
        });
    }

    @FXML
    protected void initGame(ActionEvent event) throws Exception {
        Parent page = FXMLLoader.load(Objects.requireNonNull(SOSGame.class.getResource("game.fxml")),
                null, new JavaFXBuilderFactory());
        Scene scene = new Scene(page,800, 1010);
        scene.setFill(Color.BLACK);
        Stage gameStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        gameStage.setScene(scene);
        gameStage.show();
        gameStage.centerOnScreen();
    }
}
