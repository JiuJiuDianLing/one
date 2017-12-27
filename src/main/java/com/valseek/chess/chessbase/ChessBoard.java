package com.valseek.chess.chessbase;

import com.valseek.chess.chessbase.chessman.Chessman;

/**
 * 棋盘基类 定义了一个棋盘
 */
public class ChessBoard {

    public static int[] BLACK_SUDOKU = {4,1,6,3};
    public static int[] RED_SUDOKU = {4,8,6,10};

    public static int[] BLACK_AREA = {1,1,9,5};
    public static int[] RED_AREA = {1,6,9,10};
    public static int[] DEFAULT_AREA = {0,0,0,0};
    public static int[] ALL_AREA = {1,1,9,10};


    public static int MAX_X = 9;
    public static int MAX_Y = 10;
    public static int MIN_X = 1;
    public static int MIN_Y = 1;

    // 棋盘  用来存储棋子的位置， 从1开始计数
    private Chessman[][] board;

    public ChessBoard() {
        this.board = new Chessman[11][10];
    }

    public boolean setChessman(Chessman chessman) {
        // TODO 设置棋子位置
        return true;
    }

    public boolean setChessman(Chessman chessman, ChessPosition chessPosition) {
        this.board[chessPosition.getY()][chessPosition.getX()] = chessman;
        return true;
    }


    public boolean unsetChessman(Chessman chessman) {
        // TODO 把棋子从棋盘上取下 （被吃了）
        return true;
    }

    public boolean moveChessman(Chessman chessman, ChessPosition chessPosition) {
        //TODO 把棋子从一个地方移动到另一个地方
        return true;
    }

    public Chessman[][] getBoard() {
        return this.board;
    }

    public Chessman getPositionChessman(int x, int y) {
        if (!(x >= MIN_X && x <= MAX_X && y <= MAX_Y && y >= MIN_Y)) {
            return null;
        }
        return this.board[y][x];
    }

    public boolean setPositionChessman(ChessPosition chessPosition , Chessman chessman){
        int x = chessPosition.getX();
        int y = chessPosition.getY();
        if (!(x >= MIN_X && x <= MAX_X && y <= MAX_Y && y >= MIN_Y)) {
            return false;
        }
        this.board[y][x] = chessman;
        return true;
    }

    public static int[] getSudoku(int camp)
    {
        if(camp == ChessStatic.CHESS_CAMP_RED){
            return RED_SUDOKU;
        }else if(camp == ChessStatic.CHESS_CAMP_BLACK){
            return BLACK_SUDOKU;
        }
        return new int[0];
    }

    public static int[] getCampArea(int camp){
        if(camp == ChessStatic.CHESS_CAMP_BLACK){
            return BLACK_AREA;
        }else if(camp == ChessStatic.CHESS_CAMP_RED){
            return RED_AREA;
        }
        return DEFAULT_AREA;
    }

    public static int[] getAllArea(){
        return ALL_AREA;
    }
}
