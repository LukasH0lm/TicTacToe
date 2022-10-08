package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.util.ArrayList;

import java.util.Objects;

public class Game {

    //den nuværende spiller
    private static Player currentPlayer;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    //har spillerne brugt alle deres icon?
    static boolean noMoreIcons = false;

    //er spilleren i gang med at flytte sit ikon?
    static boolean holdingIcon = false;

    static Player[] playerList;

    static int iconsLeft = 6;

    static ArrayList<ArrayList<String>> winCombos = new ArrayList<>() {
    };


        static void setup() {
        Player Player1 = new Player("X", 1);
        Player Player2 = new Player("O", 2);

        playerList = new Player[]{Player1, Player2};

        Game.currentPlayer = Player1;


        ArrayList<ArrayList<String>> winComboBuffer = new ArrayList<>() {
        };
        ArrayList<String> topCombo = new ArrayList<>() {
        };

                topCombo.add("topLeftSpace");
                topCombo.add("topMiddleSpace");
                topCombo.add("topRightSpace");


        ArrayList<String> middleHorizontalCombo = new ArrayList<>() {
        };

                middleHorizontalCombo.add("middleLeftSpace");
                middleHorizontalCombo.add("middleMiddleSpace");
                middleHorizontalCombo.add("middleRightSpace");



        ArrayList<String> bottomCombo = new ArrayList<>() {
        };

                bottomCombo.add("bottomLeftSpace");
                bottomCombo.add("bottomMiddleSpace");
                bottomCombo.add("bottomRightSpace");



        ArrayList<String> leftCombo = new ArrayList<>() {
        };

                leftCombo.add("topLeftSpace");
                leftCombo.add("middleLeftSpace");
                leftCombo.add("bottomLeftSpace");


        ArrayList<String> middleVerticalCombo = new ArrayList<>() {
        };

                middleVerticalCombo.add("topMiddleSpace");
                middleVerticalCombo.add("middleMiddleSpace");
                middleVerticalCombo.add("bottomMiddleSpace");



        ArrayList<String> rightCombo = new ArrayList<>() {
        };

                rightCombo.add("topRightSpace");
                rightCombo.add("middleRightSpace");
                rightCombo.add("bottomRightSpace");



        ArrayList<String> topLeft = new ArrayList<>() {
        };
            {
                topLeft.add("topLeftSpace");
                topLeft.add("middleMiddleSpace");
                topLeft.add("bottomRightSpace");
            }


        ArrayList<String> bottomLeft = new ArrayList<>() {
        };
            {
                bottomLeft.add("bottomLeftSpace");
                bottomLeft.add("middleMiddleSpace");
                bottomLeft.add("bottomRightSpace");
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



static void win(){
    System.out.println(currentPlayer.toString() + " Wins!");
    System.exit(0);
}


    static void checkWin(Player p){

        ArrayList<String> playerSpaces = new ArrayList<>(p.getCurrentSpaces());
        playerSpaces.sort(null);


        System.out.println("player has:" + playerSpaces);
        for (ArrayList<String> comboBuffer : winCombos) {
            comboBuffer.sort(null);

            System.out.println(comboBuffer);
            if (playerSpaces.equals(comboBuffer)) {
                win();
            }
        }

    }

    static void changePlayer(){
        if (currentPlayer == playerList[0]) {
            currentPlayer = playerList[1];
        }else{
            currentPlayer = playerList[0];
        }
    }


    public static void turnTaker(ActionEvent event){
        String pressedButtonId = ((Button) event.getSource()).getId();
        String pressedButtonText = ((Button)event.getSource()).getText();

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
            currentPlayer.getCurrentSpaces().add(pressedButtonId);
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
