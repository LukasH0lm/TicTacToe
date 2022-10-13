package com.example.tictactoe;

import java.util.LinkedList;

public class Player {

    private char icon;
    private int number;
    private LinkedList<Tile> currentTiles;
    private int wins;
    private LinkedList playerList = new LinkedList<>();
    public Player(char playerIcon, int playerNumber ){

        this.icon = playerIcon;
        this.number = playerNumber;
        this.currentTiles = new LinkedList<>();
        this.wins = 0;
        playerList.add(this);
    }

    public static Player getPlayer(int number){

        for(Player player : Game.getPlayerList()){
            System.out.println(player);
            System.out.println(player.getNumber());
            System.out.println(number);
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

    public void setCurrentTiles(Player player){

        player.currentTiles.clear();

    }


    public int getWins() {
        return wins;
    }
    public void increaseWins(){
        this.wins++;
    }

    public LinkedList getPlayerList() {
        return playerList;
    }
}
