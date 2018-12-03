package game.gui;

import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class SceneNavigator {

    public static final String menu = "main_menu.fxml";
    public static final String welcome = "welcome_screen.fxml";
    public static final String game = "game_screen.fxml";

    private static Controller controller;

    public static void setMainController(Controller controller) {
        SceneNavigator.controller = controller;
    }

    public static void loadScene(String fxml) {
        try {
            controller.setScene(FXMLLoader.load(SceneNavigator.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}