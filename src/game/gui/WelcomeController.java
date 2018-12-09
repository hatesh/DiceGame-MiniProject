package game.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

public class WelcomeController {

    @FXML
    private TextField txt_Player1Name;
    @FXML
    private TextField txt_Player2Name;
    @FXML
    private TextField txt_MaxScore;
    @FXML
    private Label lbl_Info;

    @FXML
    void loadMenu(ActionEvent event) throws IOException {
        System.out.println("Load Main Menu");
        SceneNavigator.loadScene(SceneNavigator.menuFX);
    }

    @FXML
    void loadHelp(ActionEvent event) throws IOException {
        System.out.println("Load Help Page");
        SceneNavigator.loadScene(SceneNavigator.helpFX);
    }

    @FXML
    void loadGame(ActionEvent event) throws IOException {
        String player1Name = "Player 1";
        String player2Name = "Player 2";
        if (!txt_Player1Name.getText().isEmpty()) player1Name = txt_Player1Name.getText();
        if (!txt_Player2Name.getText().isEmpty()) player2Name = txt_Player2Name.getText();
        System.out.println("Player 1: " + player1Name);
        System.out.println("Player 2: " + player2Name);
        System.out.println("Max Score: " + txt_MaxScore.getText());
        SceneNavigator.game.newPlayer(player1Name, 1);
        SceneNavigator.game.newPlayer(player2Name, 2);
        try {
            SceneNavigator.game.setMaxScore(Integer.parseInt(txt_MaxScore.getText()));
            System.out.println("Load Game");
            SceneNavigator.loadScene(SceneNavigator.gameFX);
        } catch (NumberFormatException e) {
            lbl_Info.setText("Make sure that the Max Score is filled in!");
            lbl_Info.setTextFill(Color.RED);
        }

    }

    public void initialize() {
        txt_MaxScore.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) txt_MaxScore.setText(newValue.replaceAll("\\D", ""));
            }
        });
    }

}
