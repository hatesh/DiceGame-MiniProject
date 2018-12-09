package game.gui;

import game.domain.Game;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class SceneNavigator {

    public static final String menuFX = "main_menu.fxml";
    public static final String welcomeFX = "welcome_screen.fxml";
    public static final String gameFX = "game_screen.fxml";
    public static final String winFX = "win_screen.fxml";
    public static final String helpFX = "help_screen.fxml";

    private static MainController main;
    public static Game game = new Game();

    public static void setMainController(MainController controller) {
        SceneNavigator.main = controller;
    }

    public static void loadScene(String fxml) {
        try {
            main.setScene(FXMLLoader.load(SceneNavigator.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}