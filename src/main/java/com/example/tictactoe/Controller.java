package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.LinkedList;
import java.util.List;

public class Controller {

    private Game currentGame;

    private void initialize(){

        Game currentGame = new Game();
        LinkedList<Tile> tileList = new LinkedList<>();



    }

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

        currentGame.turnTaker(event);

    }

    void updateUI(){

        /*
        topLeftSpace.setText(String.valueOf(currentGame.getTile(1).getCurrentIcon()));
        topMiddleSpace.setText(String.valueOf(currentGame.getTile(2).getCurrentIcon()));
        topRightSpace.setText(String.valueOf(currentGame.getTile(3).getCurrentIcon()));
        middleLeftSpace.setText(String.valueOf(currentGame.getTile(4).getCurrentIcon()));
        middleMiddleSpace.setText(String.valueOf(currentGame.getTile(5).getCurrentIcon()));
        middleRightSpace.setText(String.valueOf(currentGame.getTile(6).getCurrentIcon()));
        bottomLeftSpace.setText(String.valueOf(currentGame.getTile(7).getCurrentIcon()));
        bottomMiddleSpace.setText(String.valueOf(currentGame.getTile(8).getCurrentIcon()));
        bottomRightSpace.setText(String.valueOf(currentGame.getTile(9).getCurrentIcon()));
        scoreLabel1.setText(String.valueOf(currentGame.getPlayer(1).getCurrentTiles().size()));
        scoreLabel2.setText(String.valueOf(currentGame.getPlayer(2).getCurrentTiles().size()));
        turnLabel.setText(String.valueOf(currentGame.getCurrentPlayer().getIcon()));
        */

    }

}
