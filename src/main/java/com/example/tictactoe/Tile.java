package com.example.tictactoe;

public class Tile {

    private int currentPosition;
    private char currentIcon;

    public Tile(int position, char icon){

        this.currentPosition = position;
        this.currentIcon = icon;

    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public char getCurrentIcon() {
        return this.currentIcon;
    }


    public void setCurrentIcon(char currentIcon) {
        this.currentIcon = currentIcon;
    }

    public Tile identifyTile(int position){
        return this;
    }

    static Tile getTile(int position){
        for(Tile tile : Game.getTileList()){
            if(tile.getCurrentPosition() == position){
                return tile;
            }
        }
        return null;
    }

}
