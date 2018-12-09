package game.gui;

import game.graphics.DiceImage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.List;

public class GameController {

    @FXML
    private Label lbl_TurnCounter;

    @FXML
    private Label lbl_Player1Name;
    @FXML
    private Label lbl_Player1Score;
    @FXML
    private Label lbl_Player2Name;
    @FXML
    private Label lbl_Player2Score;
    @FXML
    private ProgressBar pgr_Player1Score;
    @FXML
    private ProgressBar pgr_Player2Score;
    @FXML
    private VBox vbx_Player1Info;
    @FXML
    private VBox vbx_Player2Info;

    @FXML
    private Label lbl_Dice1;
    @FXML
    private Label lbl_Dice2;
    @FXML
    private Label lbl_Dice3;
    @FXML
    private ImageView img_Dice1;
    @FXML
    private ImageView img_Dice2;
    @FXML
    private ImageView img_Dice3;

    @FXML
    private Label lbl_WhoseTurn;
    @FXML
    private Label lbl_TextOutput;
    @FXML
    private TextArea txtarea_GameLog;

    @FXML
    private Button btn_rollDice;

    @FXML
    private DiceImage diceImage;

    private Background winning;

//    @FXML void startGame(ActionEvent event) throws IOException { SceneNavigator.game.run(); }

    @FXML
    void roll(ActionEvent event) throws IOException {
        SceneNavigator.game.playerRoll(SceneNavigator.game.getTurnPlayer(SceneNavigator.game.getTurns()));
        this.updateTurnCounter();
        this.updateScores();
        this.updateTurn();
        this.updateTextOutput();
        this.updateDice();
        this.updateWinning();
        this.checkWon();
    }

    @FXML
    void checkWon() {
        if (SceneNavigator.game.checkThisGameWon()) {
            btn_rollDice.setDisable(true);
            SceneNavigator.loadScene(SceneNavigator.winFX);
        }
    }

    @FXML
    void updateTextOutput() {
        String temp = "";
        temp += SceneNavigator.game.getTurnPlayer(SceneNavigator.game.getTurns() - 1).getName();
        temp += " rolled ";
        temp += SceneNavigator.game.getRollValues().toString();
        temp += " which scores them ";
        temp += SceneNavigator.game.getRollScore();
        temp += " points!";
        lbl_TextOutput.setText(temp);
        txtarea_GameLog.setText(txtarea_GameLog.getText() + "\n" + temp);
    }

    @FXML
    void updateTurnCounter() {
        lbl_TurnCounter.setText("Turn: " + SceneNavigator.game.getTurns());
    }

    @FXML
    void updateTurn() {
        String temp = "It is ";
        temp += SceneNavigator.game.getThisTurnPlayer().getName();
        temp += "'s Turn to Roll!";
        lbl_WhoseTurn.setText(temp);
    }

    @FXML
    void updateScores() {
        int player1Score = SceneNavigator.game.getPlayer(1).getScore();
        int player2Score = SceneNavigator.game.getPlayer(2).getScore();
        lbl_Player1Score.setText("Score: " + player1Score);
        lbl_Player2Score.setText("Score: " + player2Score);
        double player1Progress = (double) player1Score / (double) SceneNavigator.game.getMaxScore();
        double player2Progress = (double) player2Score / (double) SceneNavigator.game.getMaxScore();
        pgr_Player1Score.setProgress(player1Progress);
        pgr_Player2Score.setProgress(player2Progress);
    }

    @FXML
    void updateDice() {
        List<Integer> rolls = SceneNavigator.game.getRollValues();
        this.updateDice(rolls);
    }

    @FXML
    void updateDice(List<Integer> rolls) {
        this.updateDiceLabels(rolls);
        this.updateDiceImages(rolls);
    }

    @FXML
    void updateDiceLabels(List<Integer> rolls) {
        lbl_Dice1.setText(rolls.get(0).toString());
        lbl_Dice2.setText(rolls.get(1).toString());
        lbl_Dice3.setText(rolls.get(2).toString());
    }

    @FXML
    void updateDiceImages(List<Integer> rolls) {
        img_Dice1.setImage(diceImage.getDiceFaceImage(rolls.get(0)));
        img_Dice2.setImage(diceImage.getDiceFaceImage(rolls.get(1)));
        img_Dice3.setImage(diceImage.getDiceFaceImage(rolls.get(2)));
    }

    @FXML
    void updateWinning() {
        int player1Score = SceneNavigator.game.getPlayer(1).getScore();
        int player2Score = SceneNavigator.game.getPlayer(2).getScore();
        if (player1Score > player2Score) {
            vbx_Player1Info.setBackground(winning);
            vbx_Player2Info.setBackground(Background.EMPTY);
        } else if (player2Score > player1Score) {
            vbx_Player1Info.setBackground(Background.EMPTY);
            vbx_Player2Info.setBackground(winning);
        } else {
            vbx_Player1Info.setBackground(Background.EMPTY);
            vbx_Player2Info.setBackground(Background.EMPTY);
        }
    }

    @FXML
    public void setNameLabels() {
        lbl_Player1Name.setText(SceneNavigator.game.getPlayer(1).getName());
        lbl_Player2Name.setText(SceneNavigator.game.getPlayer(2).getName());
    }

    @FXML
    public void initialize() {
        this.winning = new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY));
        this.diceImage = new DiceImage();
        this.setNameLabels();
        this.updateTurn();
        this.updateTurnCounter();
        this.updateScores();
    }

}
