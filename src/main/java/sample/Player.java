package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

public class Player {
    private int playerScore;
    private int playerNumber;
    private boolean isActive;
    private Label playerTurnInfo;

    Player(boolean active, int pNumber, Label turnInfo){
        playerScore = 0;
        isActive = active;
        playerNumber = pNumber;
        playerTurnInfo = turnInfo;
    }

    void increaseScore(int score){
        playerScore += score;
    }

    int getScore(){
        return playerScore;
    }

    void toggleActive(int score){
        if(isActive){
            increaseScore(score);
            isActive = score > 0;
        }
        else{
            if((isActive = (score == 0))){
                playerTurnInfo.setText("Tura Gracza " + playerNumber);
            }
        }
    }

    boolean getActive(){
        return isActive;
    }

}
