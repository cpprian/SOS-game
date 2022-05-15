package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button button10;
    @FXML
    private Button button11;
    @FXML
    private Button button12;
    @FXML
    private Button button13;
    @FXML
    private Button button14;
    @FXML
    private Button button15;
    @FXML
    private Button button16;
    @FXML
    private Button button17;
    @FXML
    private Button button18;
    @FXML
    private Button button19;
    @FXML
    private Button button20;
    @FXML
    private Button button21;
    @FXML
    private Button button22;
    @FXML
    private Button button23;
    @FXML
    private Button button24;
    @FXML
    private Button button25;
    @FXML
    private Button button26;
    @FXML
    private Button button27;
    @FXML
    private Button button28;
    @FXML
    private Button button29;
    @FXML
    private Button button30;
    @FXML
    private Button button31;
    @FXML
    private Button button32;
    @FXML
    private Button button33;
    @FXML
    private Button button34;
    @FXML
    private Button button35;
    @FXML
    private Button button36;
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
        buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,
                button9,button10,button11,button12,button13,button14,button15,button16,button17,button18,button19,
                button20,button21,button22,button23,button24,button25,button26,button27,button28,button29,button30,
                button31,button32,button33,button34,button35,button36));

        p1 = new Player();      //placeholder
        p2 = new Player();      //placeholder

        playerTurnInfo.setText("Tura Gracza 1");
        player1Score.setText("0");
        player2Score.setText("0");
        nextTurnButton.setDisable(true);
        restartButton.setDisable(true);
        rules = new GameRules();    //placeholder
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
        clickedButton.setDisable(true);
        nextTurnButton.setDisable(true);
        isSet = false;
        nextSymbol = "S";
        clickedButton = null;
    }

    public void resetGame(){

    }
}
