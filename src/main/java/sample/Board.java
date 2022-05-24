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

    Player p1;
    Player p2;
    GameRules rules;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>();
        for (int i = 0; i < 36; i++) {
            Button b = new Button();
            b.getStyleClass().add("button_standard");
            buttons.add(b);
            flowPane.getChildren().add(buttons.get(i));
        }
        buttons.forEach(button ->{
            setupButton(button);
            button.setFocusTraversable(false);
        });
        resetGame();
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setSymbol(button);
        });
    }
    
    private String getSymbol(Button button){
        if(Objects.equals(button.getText(), " ")){
            nextTurnButton.setDisable(false);
            button.getStyleClass().add("button_S");
            return "S";
        }
        else if(Objects.equals(button.getText(), "S")){
            nextTurnButton.setDisable(false);
            button.getStyleClass().remove("button_S");
            button.getStyleClass().add("button_O");
            return "O";
        }
        else{
            clickedButton = null;
            nextTurnButton.setDisable(true);
            button.getStyleClass().remove("button_O");
            button.getStyleClass().add("button_standard");
            return " ";
        }
    }
    
    public void setSymbol(Button button){
        if(clickedButton == null || clickedButton == button){
            clickedButton = button;
            button.setText(getSymbol(button));
        }
    }

    public void nextTurn(){
        int score = rules.searchForNewSOS(clickedButton);
        p1.toggleActive(score);
        p2.toggleActive(score);
        clickedButton.setDisable(true);
        nextTurnButton.setDisable(true);
        isSet = false;
        clickedButton = null;
        player1Score.setText(Integer.toString(p1.getScore()));
        player2Score.setText(Integer.toString(p2.getScore()));
        rules.endCheck(p1,p2);
    }

    public void resetGame(){
        p1 = new Player(true,1,playerTurnInfo);
        p2 = new Player(false,2,playerTurnInfo);

        playerTurnInfo.setText("Tura Gracza 1");
        player1Score.setText("0");
        player2Score.setText("0");
        nextTurnButton.setDisable(true);
        restartButton.setDisable(true);
        rules = new GameRules(buttons, restartButton, playerTurnInfo);
        buttons.forEach(button -> button.setText(" "));
        buttons.forEach(button -> button.setDisable(false));
        buttons.forEach(button -> button.getStyleClass().remove("button_S"));
        buttons.forEach(button -> button.getStyleClass().remove("button_O"));
    }
}
