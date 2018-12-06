package game.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


import java.io.IOException;

public class WelcomeController {

    @FXML private TextField txt_Player1Name;
    @FXML private TextField txt_Player2Name;
    @FXML private TextField txt_MaxScore;

    @FXML void loadMenu(ActionEvent event) throws IOException {
        System.out.println("Load Main Menu");
        SceneNavigator.loadScene(SceneNavigator.menuFX);
    }

    @FXML void loadGame(ActionEvent event) throws IOException {
        System.out.println("Load Game");
        SceneNavigator.loadScene(SceneNavigator.gameFX);
        System.out.println("Player 1: " + txt_Player1Name.getText());
        System.out.println("Player 2: " + txt_Player2Name.getText());
        System.out.println("Max Score: " + txt_MaxScore.getText());
        SceneNavigator.game.newPlayer(txt_Player1Name.getText(), 1);
        SceneNavigator.game.newPlayer(txt_Player2Name.getText(), 2);
        SceneNavigator.game.setMaxScore(Integer.parseInt(txt_MaxScore.getText()));
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
