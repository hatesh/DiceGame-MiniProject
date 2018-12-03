package game.gui;

import game.domain.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class gameController {
    public Game game;
    @FXML
    private TextField txt_Player1Name;
    @FXML
    private TextField txt_Player2Name;
    @FXML
    private TextField txt_MaxScore;

    @FXML
    void startGame(ActionEvent event) throws IOException {
        this.game = new Game(Integer.parseInt(txt_MaxScore.getText()));
        this.game.newPlayer(txt_Player1Name.getText(), 1);
        this.game.newPlayer(txt_Player2Name.getText(), 2);
        this.game.run();
    }
}
