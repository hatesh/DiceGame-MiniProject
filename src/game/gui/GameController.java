package game.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.List;

public class GameController {

    @FXML private Label lbl_TurnCounter;
    @FXML private Label lbl_Player1Name;
    @FXML private Label lbl_Player1Score;
    @FXML private Label lbl_Player2Name;
    @FXML private Label lbl_Player2Score;
    @FXML private ProgressBar pgr_Player1Score;
    @FXML private ProgressBar pgr_Player2Score;

    @FXML private Label lbl_Dice1;
    @FXML private Label lbl_Dice2;
    @FXML private Label lbl_Dice3;

    @FXML private Label lbl_WhoseTurn;
    @FXML private Label lbl_TextOutput;
    @FXML private TextArea txtarea_GameLog;

    @FXML private Button btn_rollDice;

//    @FXML void startGame(ActionEvent event) throws IOException { SceneNavigator.game.run(); }

    @FXML void roll(ActionEvent event) throws IOException {
        SceneNavigator.game.playerRoll(SceneNavigator.game.getTurnPlayer(SceneNavigator.game.getTurns()));
        lbl_TurnCounter.setText("Turn: " + SceneNavigator.game.getTurns());
        this.updateScores();
        this.updateTurn();
        this.updateTextOutput();
        this.updateDiceLabels();
        this.setNameLabels();
        this.checkWon();
    }

    @FXML void checkWon() {
        if (SceneNavigator.game.checkThisGameWon()) {
            btn_rollDice.setDisable(true);
            SceneNavigator.loadScene(SceneNavigator.winFX);
        }
    }

    @FXML void updateTextOutput() {
        String temp  = "";
        temp += SceneNavigator.game.getTurnPlayer(SceneNavigator.game.getTurns() - 1).getName();
        temp += " rolled ";
        temp += SceneNavigator.game.getRollValues().toString();
        temp += " which scores them ";
        temp += SceneNavigator.game.getRollScore();
        temp += " points!";
        lbl_TextOutput.setText(temp);
        txtarea_GameLog.setText(txtarea_GameLog.getText() + "\n" + temp);
    }

    @FXML void updateTurn() {
        String temp  = "It is ";
        temp += SceneNavigator.game.getThisTurnPlayer().getName();
        temp += "'s Turn to Roll!";
        lbl_WhoseTurn.setText(temp);
    }

    @FXML void updateScores() {
        lbl_Player1Score.setText("Score: " + SceneNavigator.game.getPlayer(1).getScore());
        lbl_Player2Score.setText("Score: " + SceneNavigator.game.getPlayer(2).getScore());

    }

    @FXML void updateDiceLabels() {
        List<Integer> rolls = SceneNavigator.game.getRollValues();
        lbl_Dice1.setText(rolls.get(0).toString());
        lbl_Dice2.setText(rolls.get(1).toString());
        lbl_Dice3.setText(rolls.get(2).toString());
    }

    @FXML public void setNameLabels() {
        lbl_Player1Name.setText(SceneNavigator.game.getPlayer(1).getName());
        lbl_Player2Name.setText(SceneNavigator.game.getPlayer(2).getName());
    }

    @FXML public void initialize() {
        System.out.println("Set Names");
        this.setNameLabels();
        this.updateTurn();
    }

}
