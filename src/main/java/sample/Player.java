package sample;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Player {
    private int playerScore;
    private int playerNumber;
    private boolean isActive;
    private Label playerTurnInfo;
    private Label playerName;
    private Pane playerFrame;
    private Label scoreCounter;


    Player(boolean active, int pNumber, Label turnInfo, Label name, Label counter, Pane frame){
        playerScore = 0;
        isActive = active;
        playerNumber = pNumber;
        playerTurnInfo = turnInfo;
        playerName = name;
        playerFrame = frame;
        scoreCounter = counter;
    }

    void increaseScore(int score){
        playerScore += score;
        scoreCounter.setText(Integer.toString(playerScore));
    }

    int getScore(){
        return playerScore;
    }

    void toggleActive(int score){
        if(isActive){
            increaseScore(score);
            if(!(isActive = score > 0)){
                deactivateFrame();
            }
            else{
                bonusTurnInfo();
            }
        }
        else{
            if((isActive = (score == 0))){
                activateFrame();
                newTurnInfo();
            }
        }
    }
    private void activateFrame(){
        playerName.getStyleClass().add("activePlayerName");
        playerFrame.getStyleClass().add("frame");
    }
    private void deactivateFrame(){
        playerName.getStyleClass().remove("activePlayerName");
        playerFrame.getStyleClass().remove("frame");
    }
    private void bonusTurnInfo(){
        playerTurnInfo.getStyleClass().remove("infoText");
        playerTurnInfo.getStyleClass().add("infoTextBonus");
        playerTurnInfo.setText("Bonusowa tura!");
    }
    private void newTurnInfo(){
        playerTurnInfo.getStyleClass().remove("infoTextBonus");
        playerTurnInfo.getStyleClass().add("infoText");
        playerTurnInfo.setText("Tura Gracza " + playerNumber);
    }

    boolean getActive(){
        return isActive;
    }

}
