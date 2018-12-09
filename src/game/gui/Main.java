package game.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hatesh's Dice Game");
        primaryStage.setScene(createScene(loadMainScene()));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(game.graphics.DiceImage.class.getResourceAsStream("5.jpeg")));
        primaryStage.show();
    }

    private Pane loadMainScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane mainPane = loader.load(getClass().getResourceAsStream(SceneNavigator.menuFX));
        MainController mainController = loader.getController();
        SceneNavigator.setMainController(mainController);
        return mainPane;
    }

    private Scene createScene(Pane mainPane) {
        return new Scene(mainPane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
