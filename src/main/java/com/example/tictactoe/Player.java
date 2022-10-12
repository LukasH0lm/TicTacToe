package com.example.tictactoe;

import java.util.LinkedList;

public class Player {

    private char icon;
    private static int number;
    private LinkedList<Tile> currentTiles;
    private int wins;

    public Player(char playerIcon, int playerNumber ){

        this.icon = playerIcon;
        this.number = playerNumber;
        this.currentTiles = new LinkedList<>();
        this.wins = 0;
    }

    public static Player getPlayer(int number){

        for(Player player : Game.getPlayerList()){
            if(player.getNumber() == number){
                return player;
            }
        }
        return null;

    }

    public char getIcon(){
        return this.icon;
    }

    public int getNumber(){
        return this.number;
    }

    public LinkedList<Tile> getCurrentTiles(){
        return this.currentTiles;
    }

    public int getWins() {
        return wins;
    }
    public void increaseWins(){
        this.wins++;
    }
}
