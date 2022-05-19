package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class Board implements Initializable {
    @FXML
    private FlowPane flowPane;

    @FXML
    private Button nextTurnButton;
    @FXML
    private Label player1Score;
    @FXML
    private Label player2Score;
    @FXML
    private Label playerTurnInfo;
    @FXML
    private Button restartButton;

    ArrayList<Button> buttons;
    private Button clickedButton = null;
    boolean isSet = false;
    private String nextSymbol = "S";

    Player p1;       //placeholder
    Player p2;       //placeholder
    GameRules rules; //placeholder

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>();
        for (int i = 0; i < 36; i++) {
            Button b = new Button();
            b.setStyle("-fx-min-height: 50; -fx-min-width: 50; -fx-max-height: 100; -fx-max-width: 100");
            buttons.add(b);
            flowPane.getChildren().add(buttons.get(i));
        }

        p1 = new Player(true,1,playerTurnInfo);
        p2 = new Player(false,2,playerTurnInfo);

        playerTurnInfo.setText("Tura Gracza 1");
        player1Score.setText("0");
        player2Score.setText("0");
        nextTurnButton.setDisable(true);
        restartButton.setDisable(true);
        rules = new GameRules(restartButton, playerTurnInfo);    //placeholder
        buttons.forEach(button -> button.setText(" "));
        buttons.forEach(button -> button.setDisable(false));
        buttons.forEach(button ->{
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setSymbol(button);
        });
    }

    public void setSymbol(Button button){
        if(clickedButton == null || clickedButton == button){
            clickedButton = button;
            button.setText(nextSymbol);
        }
        else{
            return;
        }
        if(Objects.equals(nextSymbol, "S")){
            nextTurnButton.setDisable(false);
            nextSymbol = "O";
        }
        else if(Objects.equals(nextSymbol, "O")){
            nextTurnButton.setDisable(false);
            nextSymbol = " ";
        }
        else{
            nextTurnButton.setDisable(true);
            clickedButton = null;
            nextSymbol = "S";
        }
    }

    public void nextTurn(){
        p1.toggleActive(0);
        p2.toggleActive(0);
        clickedButton.setDisable(true);
        nextTurnButton.setDisable(true);
        isSet = false;
        nextSymbol = "S";
        clickedButton = null;
        rules.endCheck(p1,p2);
    }

    public void resetGame(){

    }
}