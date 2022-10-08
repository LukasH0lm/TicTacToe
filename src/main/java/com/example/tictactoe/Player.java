package com.example.tictactoe;

import java.util.LinkedList;

public class Player {

    private String icon;
    private int number;
    private LinkedList<String> currentSpaces;

    public Player(String playerIcon, int playerNumber ){

        icon = playerIcon;
        number = playerNumber;
        currentSpaces = new LinkedList<>();
    }


    public String getIcon(){
        return this.icon;
    }

    public int getNumber(){
        return this.number;
    }

    public LinkedList<String> getCurrentSpaces(){
        return this.currentSpaces;
    }
}
