package game.gui;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class Controller {

    @FXML
    private GridPane rootPane;

    @FXML
    void loadWelcome(ActionEvent event) throws IOException {
        System.out.println("Load Welcome Page");
        SceneNavigator.loadScene(SceneNavigator.welcome);
    }

    public void setScene(Node node) {
        rootPane.getChildren().setAll(node);
    }

}
