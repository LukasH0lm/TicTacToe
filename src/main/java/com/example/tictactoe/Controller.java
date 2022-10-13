package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private TextArea player1TextArea;

    @FXML
    private TextArea player2TextArea;

    @FXML
    private TextArea centerTextArea;

    @FXML
    private Button newGameButton;




    @FXML
    void handleButtonClick(ActionEvent event) {

        if (!currentGame.isGameOver){
            currentGame.turnTaker(event);

        }

        updateUI();


    }

    @FXML
    void newGame(ActionEvent event){

        currentGame.newGame();
        updateUI();
        currentGame.isGameOver = false;
    }

    void updateUI(){


        topLeftSpace1.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(1)).getCurrentIcon()));
        topMiddleSpace2.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(2)).getCurrentIcon()));
        topRightSpace3.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(3)).getCurrentIcon()));
        middleLeftSpace4.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(4)).getCurrentIcon()));
        middleMiddleSpace5.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(5)).getCurrentIcon()));
        middleRightSpace6.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(6)).getCurrentIcon()));
        bottomLeftSpace7.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(7)).getCurrentIcon()));
        bottomMiddleSpace8.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(8)).getCurrentIcon()));
        bottomRightSpace9.setText(String.valueOf(Objects.requireNonNull(Tile.getTile(9)).getCurrentIcon()));
        player1TextArea.setText(String.valueOf(Objects.requireNonNull(Player.getPlayer(1)).getWins()));
        player2TextArea.setText(String.valueOf(Objects.requireNonNull(Player.getPlayer(2)).getWins()));
        centerTextArea.setText(String.valueOf(currentGame.centerTextAreaString));



    }

}
