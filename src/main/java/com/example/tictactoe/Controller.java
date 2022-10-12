package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Controller {


    Game currentGame = new Game();
    @FXML
    public void initialize() {
        LinkedList<Tile> tileList = new LinkedList<>();
    }



    @FXML
    private Button topLeftSpace1;

    @FXML
    private Button topMiddleSpace2;

    @FXML
    private Button topRightSpace3;

    @FXML
    private Button middleLeftSpace4;

    @FXML
    private Button middleMiddleSpace5;

    @FXML
    private Button middleRightSpace6;

    @FXML
    private Button bottomLeftSpace7;

    @FXML
    private Button bottomMiddleSpace8;

    @FXML
    private Button bottomRightSpace9;



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


        topLeftSpace1.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(1)).getCurrentIcon()));
        topMiddleSpace2.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(1)).getCurrentIcon()));
        topRightSpace3.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(1)).getCurrentIcon()));
        middleLeftSpace4.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(1)).getCurrentIcon()));
        middleMiddleSpace5.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(1)).getCurrentIcon()));
        middleRightSpace6.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(1)).getCurrentIcon()));
        bottomLeftSpace7.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(1)).getCurrentIcon()));
        bottomMiddleSpace8.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(1)).getCurrentIcon()));
        bottomRightSpace9.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(1)).getCurrentIcon()));
        scoreLabel1.setText(String.valueOf(Objects.requireNonNull(Player.getPlayer(1)).getWins()));
        scoreLabel2.setText(String.valueOf(Objects.requireNonNull(Player.getPlayer(2)).getWins()));
        turnLabel.setText(String.valueOf(currentGame.getCurrentPlayer().getIcon()));
        topLabel.setText(String.valueOf(currentGame.topLabelString));



    }

}
