package game.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class HelpController {

    @FXML
    private TextArea txtarea_Description;

    @FXML
    void loadMenu(ActionEvent event) throws IOException {
        System.out.println("Load Main Menu");
        SceneNavigator.loadScene(SceneNavigator.menuFX);
    }

    @FXML
    String generateHelpTest() {
        String s = "Welcome to the Dice Game!";
        s += append("In this game we have two players, each can set their own name.");
        s += append("Next a maximum score needs to be decided so a winner can be found (30 is the default).");
        s += append("After the game has been setup we can begin to play!");
        s += append("The game is simple, and goes as follows:");
        s += append("* Each Player takes it in turns to roll the dice");
        s += append(" -> 3 Dice are rolled every time");
        s += append(" -> If none of the dice share a value, you get onl 1 point");
        s += append(" -> If you roll a pair, you get the value of that pair (E.g. A pair of 4's scores 8 points)");
        s += append(" -> If you roll 3 of a kind, you score 18 points, regardless of the value!");
        s += append("* The first player to surpass the maximum wins the game!");
        s += append("* Have fun!");
        s += append("Feel free to familiarise yourself with the game screen in the other tab of the help window");
        return s;
    }

    @FXML
    void initialize() {
        txtarea_Description.setText(generateHelpTest());
    }

    public String append(String s) {
        return s + "\n";
    }
}
