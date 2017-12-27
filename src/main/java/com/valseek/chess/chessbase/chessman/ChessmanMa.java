package com.valseek.chess.chessbase.chessman;

import com.valseek.chess.chessbase.ChessGame;
import com.valseek.chess.chessbase.ChessPosition;
import com.valseek.chess.chessbase.ChessStatic;

public class ChessmanMa extends SingleStepChessman {

    private static int[][] stepArr = {{1,-2},{1,2},{-1,2},{-1,-2}};

    @Override
    protected void initLabel(int camp) {
        this.label="馬";
    }

    @Override
    public boolean stepValid(ChessPosition moveToPosition) {
        int x = this.getChessPosition().getX() + (moveToPosition.getX() - this.getChessPosition().getX()) / 2;
        int y = this.getChessPosition().getY() + (moveToPosition.getY() - this.getChessPosition().getY()) / 2;
        if(this.getChessGame().getPositionChessman(x,y) != null){
            return false;
        }
        return true;
    }

    public ChessmanMa(){

    }
    public ChessmanMa(int camp , ChessPosition chessPosition){
        super(camp,chessPosition, ChessStatic.CHESSMAN_TYPE_MA);
    }

    public int[][] getStepArr(){
        return stepArr;
    }

}
