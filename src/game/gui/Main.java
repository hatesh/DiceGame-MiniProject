package game.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hatesh's Dice Game");
        primaryStage.setScene(createScene(loadMainScene()));
        primaryStage.show();
    }

    private Pane loadMainScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane mainPane = loader.load(getClass().getResourceAsStream(SceneNavigator.menu));
        Controller mainController = loader.getController();
        SceneNavigator.setMainController(mainController);
        return mainPane;
    }

    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
