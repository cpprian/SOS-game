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
    private Button[][] buttons;
    private Integer turn;
    private final Button restartButton;
    private final Label resultInfo;
    private int posx;
    private int posy;

    public GameRules(ArrayList<Button> arButtons, Button reset, Label playerTurnInfo) {
        buttons = new Button[6][6];
        int button = 0;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                buttons[i][j] = arButtons.get(button);
                button++;
            }
        }
        restartButton = reset;
        restartButton.setDisable(true);
        resultInfo = playerTurnInfo;
        turn = 1;
    }

    public int searchForNewSOS(Button button){
        int score = 0;
        setPositions(button);
        System.out.println(buttons[posx][posy].getText());
        if(Objects.equals(buttons[posx][posy].getText(), "S")){
            if(posx > 1 && posy > 1 && Objects.equals(buttons[posx - 1][posy - 1].getText(), "O")){
                if(Objects.equals(buttons[posx - 1][posy - 1].getText(), "S")){
                    score++;
                }
            }
            if(posx > 1 && Objects.equals(buttons[posx - 1][posy].getText(), "O")){
                if(Objects.equals(buttons[posx - 2][posy].getText(), "S")){
                    score++;
                }
            }
            if(posx > 1 && posy < 4 && Objects.equals(buttons[posx - 1][posy + 1].getText(), "O")){
                if(Objects.equals(buttons[posx - 2][posy + 2].getText(), "S")){
                    score++;
                }
            }
            if(posy > 1 && Objects.equals(buttons[posx][posy - 1].getText(), "O")){
                if(Objects.equals(buttons[posx][posy - 2].getText(), "S")){
                    score++;
                }
            }
            if(posy < 4 && Objects.equals(buttons[posx][posy + 1].getText(), "O")){
                if(Objects.equals(buttons[posx][posy + 2].getText(), "S")){
                    score++;
                }
            }
            if(posx < 4 && posy > 1 && Objects.equals(buttons[posx + 1][posy - 1].getText(), "O")){
                if(Objects.equals(buttons[posx + 1][posy - 1].getText(), "S")){
                    score++;
                }
            }
            if(posx < 4 && Objects.equals(buttons[posx + 1][posy].getText(), "O")){
                if(Objects.equals(buttons[posx + 2][posy].getText(), "S")){
                    score++;
                }
            }
            if(posx < 4 && posy < 4 && Objects.equals(buttons[posx + 1][posy + 1].getText(), "O")){
                if(Objects.equals(buttons[posx + 2][posy + 2].getText(), "S")){
                    score++;
                }
            }
        }
        else{
            //pionowe
            if(posx > 0 && posx < 5 && Objects.equals(buttons[posx - 1][posy].getText(), "S")){
                if(Objects.equals(buttons[posx +1][posy].getText(), "S")){
                    score++;
                }
            }
            //poziome
            if(posy > 0 && posy < 5 && Objects.equals(buttons[posx][posy - 1].getText(), "S")){
                if(Objects.equals(buttons[posx][posy + 1].getText(), "S")){
                    score++;
                }
            }
            if(posx > 0 && posy > 0 && posx < 5 && posy < 5){
                //skos \
                if(Objects.equals(buttons[posx - 1][posy - 1].getText(), "S") && Objects.equals(buttons[posx + 1][posy + 1].getText(), "S")){
                    score++;
                }
                // skos /
                if(Objects.equals(buttons[posx + 1][posy - 1].getText(), "O") && Objects.equals(buttons[posx - 1][posy + 1].getText(), "S")){
                    score++;
                }
            }
        }
        return score;
    }
    private void setPositions(Button button){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(button == buttons[i][j]){
                    posx = i;
                    posy = j;
                    break;
                }
            }
        }
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
