package com.valseek.chess.chessbase.chessman;

import com.valseek.chess.chessbase.ChessPosition;

/**
 *  棋子基类
 */
public class Chessman {

    protected char color; // 棋子的颜色
    protected int type;
    protected boolean alive;

    /**
     * 棋子吃子
     * @param chessman
     * @return
     */
    public boolean attack(Chessman chessman){
        //TODO 棋子吃子
        return true;
    }

    public boolean moveTo(ChessPosition chessPosition){
        //TODO 棋子走子
        return true;
    }

    public boolean moveTo(int x, int y){
        //TODO 棋子走子移动到某个x y
        return true;
    }

     public void die(){
        // 棋子死掉
     }

}
