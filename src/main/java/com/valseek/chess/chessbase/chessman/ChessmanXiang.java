package com.valseek.chess.chessbase.chessman;

import com.valseek.chess.chessbase.ChessBoard;
import com.valseek.chess.chessbase.ChessGame;
import com.valseek.chess.chessbase.ChessPosition;
import com.valseek.chess.chessbase.ChessStatic;

public class ChessmanXiang extends SingleStepChessman {

    public boolean stepValid(ChessPosition moveToPosition) {
        int x = this.getChessPosition().getX() + (moveToPosition.getX() - this.getChessPosition().getX()) / 2;
        int y = this.getChessPosition().getY() + (moveToPosition.getY() - this.getChessPosition().getY()) / 2;
        if(this.getChessGame().getPositionChessman(x,y) != null){
            return false;
        }
        int[] selfArea = ChessBoard.getCampArea(this.getCamp());
        if(!ChessStatic.positionInArea(moveToPosition,selfArea)){
            return false;
        }
        return true;
    }

    @Override
    protected void initLabel(int camp) {
        if(camp == ChessStatic.CHESS_CAMP_RED){
            this.label="相";
        }else{
            this.label="象";
        }
    }

    public ChessmanXiang(){

    }
    public ChessmanXiang(int camp , ChessPosition chessPosition){
        super(camp,chessPosition, ChessStatic.CHESSMAN_TYPE_XIANG);
    }

    private static int[][] stepArr = {{2,-2},{2,2},{-2,2},{-2,-2}};
    @Override
    public int[][] getStepArr(){
        return stepArr;
    }

}
