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
    private ArrayList<Tile> middleVerticalCombo;
    private ArrayList<Tile> rightCombo;
    private ArrayList<Tile> topLeftCombo;
    private ArrayList<Tile> bottomLeftCombo;


    String centerTextAreaString = "";

    public static LinkedList<Tile> getTileList() {
        return tileList;

    }


    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    //har spillerne brugt alle deres icon?
    private boolean hasIconsLeft = true;

    //er spilleren i gang med at flytte sit ikon?
    private boolean holdingIcon = false;

    boolean isGameOver = false;

    static LinkedList<Player> playerList;

    public static LinkedList<Player> getPlayerList(){
        System.out.println(playerList);
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
        //den gode måde at gøre det på ville være at Tile1 ville være index 0, eller kalde Tile1 Tile0
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

        bottomLeftCombo = new ArrayList<Tile>();
        bottomLeftCombo.add(tile7);
        bottomLeftCombo.add(tile5);
        bottomLeftCombo.add(tile3);
        winCombos.add(bottomLeftCombo);


        System.out.println(winCombos);


    }


    void win(){
    System.out.println(currentPlayer.toString() + " Wins!");
    currentPlayer.increaseWins();
    centerTextAreaString = String.valueOf("player" + getCurrentPlayer().getNumber() + " has won!");
    isGameOver = true;

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

        System.out.println("Player List");
        System.out.println(playerList);

        System.out.println("Changing player");
        System.out.println(currentPlayer);
        System.out.println(playerList.get(0));
        System.out.println(playerList.get(1));


        if (currentPlayer == playerList.get(0)) {
            currentPlayer = playerList.get(1);
        }else{
            currentPlayer = playerList.get(0);
        }
    }


    public void turnTaker(ActionEvent event) {


        String bufferId = ((Button) event.getSource()).getId();
        int bufferIntId = Integer.parseInt(bufferId.substring(bufferId.length() - 1));
        System.out.println(bufferIntId);
        Tile currentTile = getTileList().get(bufferIntId);

        int pressedButtonId = currentTile.getCurrentPosition();

        char pressedButtonIcon = currentTile.getCurrentIcon();
        System.out.println(pressedButtonIcon);


        if (hasIconsLeft) {
            //hvis spilleren har ikoner tilbage
            if (Objects.equals(pressedButtonIcon, ' ')) {
                currentTile.setCurrentIcon(currentPlayer.getIcon());
                currentPlayer.getCurrentTiles().add(currentTile);
                checkWin(currentPlayer);

                currentTile.setCurrentIcon(currentPlayer.getIcon());

                changePlayer();
                iconsLeft--;
                if (iconsLeft == 0) {
                    hasIconsLeft = false;
                }
            } else {
                System.out.println("ERROR: space is already occupied");
                centerTextAreaString = "space is already occupied";

            }

        } else if (holdingIcon) {

            //hvis spillerne ikke har flere ikoner og currentPLayer holder et icon
            if (Objects.equals(pressedButtonIcon, ' ')) {
                currentTile.setCurrentIcon(currentPlayer.getIcon());
                holdingIcon = false;
                currentPlayer.getCurrentTiles().add(currentTile);
                checkWin(currentPlayer);
                changePlayer();
            } else {
                centerTextAreaString = "tile is not empty";
                System.out.println("ERROR: tile is not empty");
            }

            //hvis spilleren ikke har flere ikoner og clicker på et af sine egne ikoner
        } else if (Objects.equals(pressedButtonIcon, currentPlayer.getIcon())) {


            currentTile.setCurrentIcon(' ');
            currentPlayer.getCurrentTiles().remove(currentTile);
            holdingIcon = true;
        } else {
            centerTextAreaString = "player cannot take this icon";

            System.out.println("ERROR: player cannot take this icon");

        }



        }


    public void newGame() {

        iconsLeft = 6;
        hasIconsLeft = true;

        for(Tile tile : tileList){

            tile.setCurrentIcon(' ');

        }

        for (Player player : playerList){
            player.setCurrentTiles(player);
        }

        changePlayer();


    }
}

