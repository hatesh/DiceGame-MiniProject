package game.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class Controller {

    @FXML
    private GridPane rootPane;
    @FXML
    private Button btn_StartGame;
    @FXML
    private TextField txt_Player1Name;
    @FXML
    private TextField txt_Player2Name;
    @FXML
    private TextField txt_MaxScore;


    @FXML
    void loadWelcome(ActionEvent event) throws IOException {
        System.out.println("Load Welcome Page");
        GridPane pane = FXMLLoader.load(getClass().getResource("welcome_screen.fxml"));
        rootPane.getChildren().setAll(pane);
    }

//    @FXML
//    void loadMenu(ActionEvent event) throws IOException {
//        System.out.println("Load Main Menu");
//        GridPane pane = FXMLLoader.load(getClass().getResource("main_menu.fxml"));
//        rootPane.getChildren().setAll(pane);
//    }
//
//    @FXML
//    void loadGame(ActionEvent event) throws IOException{
//        System.out.println("Load Game");
//        GridPane pane = FXMLLoader.load(getClass().getResource("game_screen.fxml"));
//        rootPane.getChildren().setAll(pane);
//        System.out.println("Player 1: " + txt_Player1Name.getText());
//        System.out.println("Player 2: " + txt_Player2Name.getText());
//    }


}
