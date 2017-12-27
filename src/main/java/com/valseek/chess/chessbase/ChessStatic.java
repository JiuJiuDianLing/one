package com.valseek.chess.chessbase;

/**
 * 棋的静态数据
 */
public class ChessStatic {
    // 棋子类型
    static final public int CHESSMAN_TYPE_JU = 1;
    static final public int CHESSMAN_TYPE_MA = 2;
    static final public int CHESSMAN_TYPE_XIANG = 3;
    static final public int CHESSMAN_TYPE_SHI = 4;
    static final public int CHESSMAN_TYPE_SHUAI = 5;
    static final public int CHESSMAN_TYPE_PAO = 6;
    static final public int CHESSMAN_TYPE_ZU = 7;

    // 阵营
    static final public int CHESS_CAMP_RED = 0;
    static final public char CHESS_CAMP_BLACK = 1;

    private ChessPosition[][] chessPositions;

    private ChessStatic() {
        chessPositions = new ChessPosition[11][10];
    }

    ;
    private static ChessStatic instance = null;

    public static ChessStatic getInstance() {
        if (instance == null) {
            instance = new ChessStatic();
            return instance;
        }
        return instance;
    }

    public ChessPosition getPosition(int x, int y) {
        if (this.chessPositions[y][x] == null) {
            this.chessPositions[y][x] = new ChessPosition(x, y);
        }
        return this.chessPositions[y][x];
    }


    public static boolean positionInArea(int x, int y, int[] area) {
        if (x < area[0] ||
                x > area[2] ||
                y < area[1] ||
                y > area[3]) {
            return false;
        }
        return true;
    }

    public static boolean positionInArea(ChessPosition chessPosition, int[] area) {
        if (chessPosition.getX() < area[0] ||
                chessPosition.getX() > area[2] ||
                chessPosition.getY() < area[1] ||
                chessPosition.getY() > area[3]) {
            return false;
        }
        return true;
    }


}
