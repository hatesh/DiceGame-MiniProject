package game.gui;

import game.domain.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.List;

public class WinController {

    @FXML
    private Label lbl_WinMessage;

    @FXML
    void loadMenu(ActionEvent event) throws IOException {
        System.out.println("Load Main Menu");
        SceneNavigator.loadScene(SceneNavigator.menuFX);
    }

    @FXML
    void newPlayers(ActionEvent event) throws IOException {
        System.out.println("Load Welcome Screen");
        SceneNavigator.game.reset();
        SceneNavigator.game.clearPlayerList();
        SceneNavigator.loadScene(SceneNavigator.welcomeFX);
    }

    @FXML
    void rematch(ActionEvent event) throws IOException {
        System.out.println("Loading Rematch");
        SceneNavigator.game.reset();
        SceneNavigator.loadScene(SceneNavigator.gameFX);
    }

    @FXML
    void setWinMessage() {
        String temp = "Congratulations on ";
        List<Player> winners = SceneNavigator.game.getThisGameWinners();
        if (winners.size() > 1) {
            for (Player w : winners) {
                temp += w.getName() + " and ";
            }
            temp = temp.substring(0, temp.length() - 4);
            temp += " on Drawing!";
        } else {
            temp += winners.get(0).getName() + " on Winning!";
        }
        lbl_WinMessage.setText(temp);
    }

    @FXML
    public void initialize() {
        this.setWinMessage();
    }

}
