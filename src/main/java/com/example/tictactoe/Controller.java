package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    

    @FXML
    private Button bottomLeftSpace;

    @FXML
    private Button bottomMiddleSpace;

    @FXML
    private Button bottomRightSpace;

    @FXML
    private Button middleLeftSpace;

    @FXML
    private Button middleMiddleSpace;

    @FXML
    private Button middleRightSpace;

    @FXML
    private Label scoreLabel1;

    @FXML
    private Label scoreLabel2;

    @FXML
    private Label topLabel;

    @FXML
    private Button topLeftSpace;

    @FXML
    private Button topMiddleSpace;

    @FXML
    private Button topRightSpace;

    @FXML
    public Label turnLabel;

    @FXML
    void handleButtonClick(ActionEvent event) {
        String pressedButtonId = ((Button) event.getSource()).getId();
        String pressedButtonText = ((Button)event.getSource()).getText();
        System.out.println(pressedButtonId);
        System.out.println(pressedButtonText);

        Game.turnTaker(event);

    }

}
