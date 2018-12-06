package game.gui;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class MainController {

    @FXML private GridPane rootPane;

    @FXML public void initialize() { System.out.println("Application started"); }

    @FXML void loadWelcome(ActionEvent event) throws IOException {
        System.out.println("Load Welcome Page");
        SceneNavigator.loadScene(SceneNavigator.welcomeFX);
    }

    public void setScene(Node node) {
        rootPane.getChildren().setAll(node);
    }

}