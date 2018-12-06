package game.gui;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.List;

public class GameController {

    @FXML private GridPane pane_GameScreen;

    @FXML private Label lbl_TurnCounter;
    @FXML private Label lbl_Player1Name;
    @FXML private Label lbl_Player1Score;
    @FXML private Label lbl_Player2Name;
    @FXML private Label lbl_Player2Score;

    @FXML private Label lbl_Dice1;
    @FXML private Label lbl_Dice2;
    @FXML private Label lbl_Dice3;

    @FXML private Button btn_rollDice;

    @FXML void startGame(ActionEvent event) throws IOException { SceneNavigator.game.run(); }

    @FXML void roll(ActionEvent event) throws IOException {
        SceneNavigator.game.playerRoll(SceneNavigator.game.getTurnPlayer(SceneNavigator.game.getTurns()));
        lbl_TurnCounter.setText("Turn: " + SceneNavigator.game.getTurns());
        this.updateScores();
        this.updateDiceLabels();
        this.setNameLabels();
    }

    @FXML void updateScores() {
        lbl_Player1Score.setText("Score: " + Integer.toString(SceneNavigator.game.getPlayer(1).getScore()));
        lbl_Player2Score.setText("Score: " + Integer.toString(SceneNavigator.game.getPlayer(2).getScore()));
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
        System.out.println(SceneNavigator.game.getPlayer(1).getName());
        System.out.println(SceneNavigator.game.getPlayer(2).getName());
        this.setNameLabels();
    }

}
