package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Button topLeftSpace;

    @FXML
    private Button topMiddleSpace;

    @FXML
    private Button topRightSpace;

    @FXML
    private Button middleLeftSpace;

    @FXML
    private Button middleMiddleSpace;

    @FXML
    private Button middleRightSpace;

    @FXML
    private Button bottomLeftSpace;

    @FXML
    private Button bottomMiddleSpace;

    @FXML
    private Button bottomRightSpace;



    @FXML
    private Label scoreLabel1;

    @FXML
    private Label scoreLabel2;

    @FXML
    private Label topLabel;



    @FXML
    private Label turnLabel;

    @FXML
    void handleButtonClick(ActionEvent event) {

        Game.turnTaker(event);

    }

}
