package com.example.tictactoe;

import java.util.LinkedList;

public class Player {

    String icon;
    int Number;
    LinkedList<String> currentSpaces;

    public Player(String playerIcon, int playerNumber ){

        icon = playerIcon;
        Number = playerNumber;
        currentSpaces = new LinkedList<>();
    }

    /* burde bruges når vi refactor koden

    public String getIcon(){
        return this.icon;
    }

    public int getNumber(){
        return this.Number;
    }
*/

}
