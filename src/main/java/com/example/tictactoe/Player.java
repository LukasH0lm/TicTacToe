package com.example.tictactoe;

import java.util.LinkedList;

public class Player {

    private String icon;
    private int number;
    private LinkedList<Tile> currentTiles;

    public Player(String playerIcon, int playerNumber ){

        icon = playerIcon;
        number = playerNumber;
        currentTiles = new LinkedList<>();
    }


    public String getIcon(){
        return this.icon;
    }

    public int getNumber(){
        return this.number;
    }

    public LinkedList<Tile> getCurrentTiles(){
        return this.currentTiles;
    }
}
