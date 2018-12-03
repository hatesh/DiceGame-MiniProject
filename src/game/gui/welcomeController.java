package game.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;

public class welcomeController {
    @FXML
    private Button btn_StartGame;
    @FXML
    private TextField txt_Player1Name;
    @FXML
    private TextField txt_Player2Name;
    @FXML
    private TextField txt_MaxScore;

    @FXML
    void loadMenu(ActionEvent event) throws IOException {
        System.out.println("Load Main Menu");
        SceneNavigator.loadScene(SceneNavigator.menu);
    }

    @FXML
    void loadGame(ActionEvent event) throws IOException {
        System.out.println("Load Game");
        SceneNavigator.loadScene(SceneNavigator.game);
        System.out.println("Player 1: " + txt_Player1Name.getText());
        System.out.println("Player 2: " + txt_Player2Name.getText());
        System.out.println("Max Score: " + txt_MaxScore.getText());


    }

}
