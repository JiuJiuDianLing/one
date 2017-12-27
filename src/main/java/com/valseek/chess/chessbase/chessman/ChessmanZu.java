package com.valseek.chess.chessbase.chessman;

import com.valseek.chess.chessbase.ChessBoard;
import com.valseek.chess.chessbase.ChessPosition;
import com.valseek.chess.chessbase.ChessStatic;

public class ChessmanZu extends SingleStepChessman{

    private static int[][] redStepArr = {{0,-1},{-1,0},{1,0}};
    private static int[][] blackStepArr = {{0,1},{-1,0},{1,0}};
    private static int[][] defaultStepArr = {};



    @Override
    public boolean stepValid(ChessPosition moveToPosition) {
        int[] selfArea = ChessBoard.getCampArea(this.getCamp());
        // 在自己的区域只能他妈的前进
        if(ChessStatic.positionInArea(this.getChessPosition() , selfArea)){
            if(moveToPosition.getX() != this.getChessPosition().getX()){
                return false;
            }
        }
        return true;
    }

    @Override
    protected void initLabel(int camp) {
        if(camp == ChessStatic.CHESS_CAMP_RED){
            this.label="兵";
        }else{
            this.label="卒";
        }
    }

    public ChessmanZu() {
    }

    public ChessmanZu(int camp, ChessPosition chessPosition) {
        super(camp,chessPosition, ChessStatic.CHESSMAN_TYPE_ZU);
    }

    @Override
    public int[][] getStepArr() {
        if(this.getCamp() == ChessStatic.CHESS_CAMP_RED){
            return redStepArr;
        }else if(this.getCamp() == ChessStatic.CHESS_CAMP_BLACK){
            return blackStepArr;
        }
        return defaultStepArr;
    }
}
