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

public class GameRules {
    private Integer turn;
    private final Button restartButton;
    private final Label resultInfo;

    public GameRules(Button reset, Label playerTurnInfo) {
        restartButton = reset;
        restartButton.setDisable(true);
        resultInfo = playerTurnInfo;
        turn = 1;
    }

    public void endCheck(Player p1, Player p2){
        turn++;
        if(turn > 36){
            restartButton.setDisable(false);
            if(p1.getScore() > p2.getScore()){
                resultInfo.setText("Wygrał Gracz 1!");
            }
            else if(p2.getScore() > p1.getScore()){
                resultInfo.setText("Wygrał Gracz 2!");
            }
            else{
                resultInfo.setText("Remis!");
            }
        }
    }
}
