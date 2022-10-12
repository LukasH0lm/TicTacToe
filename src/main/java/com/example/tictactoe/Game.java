package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Game {

    //den nuværende spiller
    private Player currentPlayer;

    private LinkedList<Tile> tileList = new LinkedList<>();

    public LinkedList<Tile> getTileList() {
        return tileList;

    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    //har spillerne brugt alle deres icon?
    private boolean noMoreIcons = false;

    //er spilleren i gang med at flytte sit ikon?
    private boolean holdingIcon = false;

    Player[] playerList;

    private int iconsLeft = 6;


    private ArrayList<ArrayList<Tile>> winCombos = new ArrayList<>() {
    };

    public Game() {
        setup();
    }
        void setup() {
        Player Player1 = new Player("X", 1);
        Player Player2 = new Player("O", 2);

        playerList = new Player[]{Player1, Player2};

        this.currentPlayer = Player1;


        Tile tile1 = new Tile(1,' ');
        Tile tile2 = new Tile(2,' ');
        Tile tile3 = new Tile(3,' ');
        Tile tile4 = new Tile(4,' ');
        Tile tile5 = new Tile(5,' ');
        Tile tile6 = new Tile(6,' ');
        Tile tile7 = new Tile(7,' ');
        Tile tile8 = new Tile(8,' ');
        Tile tile9 = new Tile(9,' ');

        LinkedList<Tile> tileList = new LinkedList<>(
                    List.of(tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9)
        );



        ArrayList<ArrayList<Tile>> winComboBuffer = new ArrayList<>() {
        };
        ArrayList<Tile> topCombo = new ArrayList<>() {
        };

                topCombo.add(tile1);
                topCombo.add(tile2);
                topCombo.add(tile3);



            ArrayList<Tile> middleHorizontalCombo = new ArrayList<>() {
        };

            topCombo.add(tile4);
            topCombo.add(tile5);
            topCombo.add(tile6);



        ArrayList<Tile> bottomCombo = new ArrayList<>() {
        };

            topCombo.add(tile7);
            topCombo.add(tile8);
            topCombo.add(tile9);



        ArrayList<Tile> leftCombo = new ArrayList<>() {
        };

            topCombo.add(tile1);
            topCombo.add(tile4);
            topCombo.add(tile7);


        ArrayList<Tile> middleVerticalCombo = new ArrayList<>() {
        };

            topCombo.add(tile2);
            topCombo.add(tile5);
            topCombo.add(tile8);



        ArrayList<Tile> rightCombo = new ArrayList<>() {
        };

            topCombo.add(tile3);
            topCombo.add(tile6);
            topCombo.add(tile9);



        ArrayList<Tile> topLeft = new ArrayList<>() {
        };
            {
                topCombo.add(tile1);
                topCombo.add(tile5);
                topCombo.add(tile9);
            }


        ArrayList<Tile> bottomLeft = new ArrayList<>() {
        };
            {
                topCombo.add(tile7);
                topCombo.add(tile5);
                topCombo.add(tile3);
            }



        winComboBuffer.add(topCombo);
        winComboBuffer.add(middleHorizontalCombo);
        winComboBuffer.add(bottomCombo);
        winComboBuffer.add(leftCombo);
        winComboBuffer.add(middleVerticalCombo);
        winComboBuffer.add(rightCombo);
        winComboBuffer.add(topLeft);
        winComboBuffer.add(bottomLeft);


        winCombos = winComboBuffer;
    }


    void win(){
    System.out.println(currentPlayer.toString() + " Wins!");
    System.exit(0);
}


    void checkWin(Player p){

        ArrayList<Tile> playerSpaces = new ArrayList<>(p.getCurrentTiles());
        playerSpaces.sort(null);


        System.out.println("player has:" + playerSpaces);
        for (ArrayList<Tile> comboBuffer : winCombos) {
            comboBuffer.sort(null);

            System.out.println(comboBuffer);
            if (playerSpaces.equals(comboBuffer)) {
                win();
            }
        }

    }

    void changePlayer(){
        if (currentPlayer == playerList[0]) {
            currentPlayer = playerList[1];
        }else{
            currentPlayer = playerList[0];
        }
    }


    public void turnTaker(ActionEvent event){



        Tile currentTile = getTileList().get(Integer.parseInt(((Button) event.getSource()).getId()) - 1);

        int pressedButtonId = currentTile.getCurrentPosition();

        char pressedButtonText = currentTile.getCurrentIcon();


        if (noMoreIcons){
            if (holdingIcon){
                //hvis spillerne ikke har flere ikoner og currentPLayer holder et icon
                if (Objects.equals(pressedButtonText, "")){
                    ((Button)event.getSource()).setText(currentPlayer.getIcon());
                    holdingIcon = false;
                    changePlayer();
                }else {
                    System.out.println("ERROR: space is already occupied");
                }
                //hvis spilleren ikke har flere ikoner og clicker på et af sine egne ikoner
            }else if (Objects.equals(pressedButtonText, currentPlayer.getIcon())){
                ((Button)event.getSource()).setText("");
                holdingIcon = true;

            }

            //hvis spillerne har flere brikker tilbage
        } else if (Objects.equals(pressedButtonText, "")){
            ((Button)event.getSource()).setText(currentPlayer.getIcon());
            currentPlayer.getCurrentTiles().add(currentTile.getCurrentPosition());
            checkWin(currentPlayer);

            changePlayer();
            iconsLeft--;
            if(iconsLeft == 0){
                noMoreIcons = true;
            }

        }else{

            System.out.println("ERROR: space is already occupied");

        }
    }
}
