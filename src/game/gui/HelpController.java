package game.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class HelpController {

    @FXML private TextArea txtarea_Description;

    @FXML void loadMenu(ActionEvent event) throws IOException {
        System.out.println("Load Main Menu");
        SceneNavigator.loadScene(SceneNavigator.menuFX);
    }

    @FXML String generateHelpTest() {
        String s = "Welcome to the Dice Game!";
        s = append(s, "In this game we have two players, each can set their own name.");
        s = append(s, "Next a maximum score needs to be decided so a winner can be found (30 is the default).");
        s = append(s, "After the game has been set up we can begin to play!");
        s = append(s, "The game is simple, and goes as follows:");
        s = append(s, "* Each Player takes it in turns to roll the dice");
        s = append(s, " -> 3 Dice are rolled every time");
        s = append(s, " -> If none of the dice share a value, you get only 1 point");
        s = append(s, " -> If you roll a pair, you get the value of that pair (E.g. A pair of 4's scores 8 points)");
        s = append(s, " -> If you roll 3 of a kind, you score 18 points, regardless of the value!");
        s = append(s, "* The first player to surpass the maximum wins the game!");
        s = append(s, "* Have fun!");
        s = append(s, "Feel free to familiarise yourself with the game screen in the other tab of the help window");
        return s;
    }

    @FXML void initialize() {
        txtarea_Description.setText(generateHelpTest());
    }

    public String append(String s1, String s2) { return s1 + "\n" + s2; }
}
