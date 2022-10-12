package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.util.*;

public class Game {

    //den nuværende spiller
    private Player currentPlayer;

    private static LinkedList<Tile> tileList;
    private ArrayList<Tile> topCombo;
    private ArrayList<Tile> middleCombo;
    private ArrayList<Tile> bottomCombo;
    private ArrayList<Tile> leftCombo;
    private ArrayList<Tile> middleHorizontalCombo;
    private ArrayList<Tile> rightCombo;
    private ArrayList<Tile> a7;
    private ArrayList<Tile> topLeftCombo;
    private ArrayList<Tile> bottomLeftCombo;
    private ArrayList<Tile> middleVerticalCombo;

    String topLabelString;

    public static LinkedList<Tile> getTileList() {
        return tileList;

    }

    public static LinkedList<Player> getPlayer() {
        return playerList;

    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    //har spillerne brugt alle deres icon?
    private boolean hasIconsLeft = true;

    //er spilleren i gang med at flytte sit ikon?
    private boolean holdingIcon = false;

    static LinkedList<Player> playerList;

    public static LinkedList<Player> getPlayerList(){
        return playerList;
    }

    private int iconsLeft = 6;


    private ArrayList<ArrayList<Tile>> winCombos = new ArrayList<ArrayList<Tile>>();

    public Game() {
        setup();
    }
    void setup() {
        Player Player1 = new Player('X', 1);
        Player Player2 = new Player('O', 2);

        playerList = new LinkedList<>(){};

        playerList.add(Player1);
        playerList.add(Player2);


        this.currentPlayer = Player1;


        //tile0 er en quick and dirty måde at undgå IndexOutOfBounds
        Tile tile0 = new Tile(0,' ');
        Tile tile1 = new Tile(1,' ');
        Tile tile2 = new Tile(2,' ');
        Tile tile3 = new Tile(3,' ');
        Tile tile4 = new Tile(4,' ');
        Tile tile5 = new Tile(5,' ');
        Tile tile6 = new Tile(6,' ');
        Tile tile7 = new Tile(7,' ');
        Tile tile8 = new Tile(8,' ');
        Tile tile9 = new Tile(9,' ');
        Tile tile10 = new Tile(10,' ');

        tileList = new LinkedList<>(
                    List.of(tile0,tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9)
        );


        topCombo = new ArrayList<Tile>();
        topCombo.add(tile1);
        topCombo.add(tile2);
        topCombo.add(tile3);
        winCombos.add(topCombo);


        middleCombo = new ArrayList<Tile>();
        middleCombo.add(tile4);
        middleCombo.add(tile5);
        middleCombo.add(tile6);
        winCombos.add(middleCombo);


        bottomCombo = new ArrayList<Tile>();
        bottomCombo.add(tile7);
        bottomCombo.add(tile8);
        bottomCombo.add(tile9);
        winCombos.add(bottomCombo);

        leftCombo = new ArrayList<Tile>();
        leftCombo.add(tile1);
        leftCombo.add(tile4);
        leftCombo.add(tile7);
        winCombos.add(leftCombo);

        middleVerticalCombo = middleHorizontalCombo;
        middleVerticalCombo = new ArrayList<Tile>();
        middleVerticalCombo.add(tile2);
        middleVerticalCombo.add(tile5);
        middleVerticalCombo.add(tile8);
        winCombos.add(middleVerticalCombo);

        rightCombo = new ArrayList<Tile>();
        rightCombo.add(tile3);
        rightCombo.add(tile6);
        rightCombo.add(tile9);
        winCombos.add(rightCombo);

        topLeftCombo = new ArrayList<Tile>();
        topLeftCombo.add(tile1);
        topLeftCombo.add(tile5);
        topLeftCombo.add(tile9);
        winCombos.add(topLeftCombo);

        topLeftCombo = new ArrayList<Tile>();
        this.topLeftCombo.add(tile7);
        this.topLeftCombo.add(tile5);
        this.topLeftCombo.add(tile3);
        winCombos.add(this.topLeftCombo);


        System.out.println(winCombos);


    }


    void win(){
    System.out.println(currentPlayer.toString() + " Wins!");
    System.exit(0);
}


    void checkWin(Player p){

        ArrayList<Tile> playerSpaces = new ArrayList<>(p.getCurrentTiles());

        playerSpaces.sort(Comparator.comparing(Tile::getCurrentPosition));

        System.out.println("player has:" + playerSpaces);
        for (ArrayList<Tile> comboBuffer : winCombos) {
            comboBuffer.sort(Comparator.comparing(Tile::getCurrentPosition));


            System.out.println(comboBuffer);
            if (playerSpaces.equals(comboBuffer)) {
                win();
            }
        }

    }

    void changePlayer(){
        if (currentPlayer == playerList.get(0)) {
            currentPlayer = playerList.get(1);
        }else{
            currentPlayer = playerList.get(0);
        }
    }


    public void turnTaker(ActionEvent event){

        String bufferId = ((Button) event.getSource()).getId();
        int bufferIntId = Integer.parseInt(bufferId.substring(bufferId.length() -1));
        System.out.println(bufferIntId);
        Tile currentTile = getTileList().get(bufferIntId);

        int pressedButtonId = currentTile.getCurrentPosition();

        char pressedButtonIcon = currentTile.getCurrentIcon();
        System.out.println(pressedButtonIcon);


        if (hasIconsLeft){

            //hvis spilleren har ikoner tilbage
            if(Objects.equals(pressedButtonIcon, ' ')) {
                ((Button) event.getSource()).setText(Character.toString(currentPlayer.getIcon()));
                currentPlayer.getCurrentTiles().add(currentTile);
                checkWin(currentPlayer);

                currentTile.setCurrentIcon(currentPlayer.getIcon());

                changePlayer();
                iconsLeft--;
                if (iconsLeft == 0) {
                    hasIconsLeft = false;
                }
            }else{
                System.out.println("ERROR: space is already occupied");
                topLabelString = "space is already occupied";

            }

        }else if (holdingIcon) {

            //hvis spillerne ikke har flere ikoner og currentPLayer holder et icon
            if (Objects.equals(pressedButtonIcon, ' ')){
                ((Button)event.getSource()).setText(Character.toString(currentPlayer.getIcon()));
                holdingIcon = false;
                changePlayer();
            }
        }else if (Objects.equals(pressedButtonIcon, currentPlayer.getIcon())){
            ((Button)event.getSource()).setText(" ");
            holdingIcon = true;

                //hvis spillerne ikke har flere ikoner og currentPLayer holder et icon
                if (Objects.equals(pressedButtonIcon, ' ')){
                    ((Button)event.getSource()).setText(Character.toString(currentPlayer.getIcon()));
                    holdingIcon = false;
                    changePlayer();
                }else {
                    System.out.println(pressedButtonIcon);
                    System.out.println("ERROR: space is already occupied");
                }
                //hvis spilleren ikke har flere ikoner og clicker på et af sine egne ikoner



        }
    }
}
