package game.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class MainController {

    @FXML
    private GridPane rootPane;

    @FXML
    public void initialize() {
        System.out.println("Application started");
    }

    @FXML
    void loadWelcome(ActionEvent event) throws IOException {
        System.out.println("Load Welcome Page");
        SceneNavigator.loadScene(SceneNavigator.welcomeFX);
    }

    @FXML
    void loadHelp(ActionEvent event) throws IOException {
        System.out.println("Load Help Page");
        SceneNavigator.loadScene(SceneNavigator.helpFX);
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        System.out.println("Quitting");
        System.exit(0);
    }

    public void setScene(Node node) {
        rootPane.getChildren().setAll(node);
    }

}
