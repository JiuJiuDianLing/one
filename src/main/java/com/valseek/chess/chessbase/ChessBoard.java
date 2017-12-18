package com.valseek.chess.chessbase;

import com.valseek.chess.chessbase.chessman.Chessman;

/**
 *  棋盘基类 定义了一个棋盘
 */
public class ChessBoard {

    // 棋盘  用来存储棋子的位置， 从1开始计数
    private Chessman[][] board;

    public ChessBoard(){
        this.board = new Chessman[10][11];
    }

    public boolean setChessman(Chessman chessman){
        // TODO 设置棋子位置
        return true;
    }

    public boolean setChessman(Chessman chessman , ChessPosition chessPosition){
        // TODO 设置棋子，根据位置
        return true;
    }

    public boolean unsetChessman(Chessman chessman){
        // TODO 把棋子从棋盘上取下 （被吃了）
        return true;
    }

    public boolean moveChessman(Chessman chessman , ChessPosition chessPosition){
        //TODO 把棋子从一个地方移动到另一个地方
        return true;
    }


}
