package com.valseek.chess.chessbase;

public class ChessPosition {

    private int x;
    private int y;

    public ChessPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean move(int cx,int cy){
        int nx = this.x+cx;
        int ny = this.y+cy;
        if(this.x <= 0 || this.y <=0){
            return false;
        }
        this.x = nx;
        this.y = ny;
        return true;
    }
}
