package com.valseek.chess.chessbase.chessman;

import com.valseek.chess.chessbase.ChessBoard;
import com.valseek.chess.chessbase.ChessGame;
import com.valseek.chess.chessbase.ChessPosition;
import com.valseek.chess.chessbase.ChessStatic;

public class ChessmanSi extends SingleStepChessman{

    @Override
    protected void initLabel(int camp) {
        this.label="士";
    }

    @Override
    public boolean stepValid(ChessPosition moveToPosition) {
        int[] sudoku = ChessBoard.getSudoku(this.getCamp());
        if(!ChessStatic.positionInArea(moveToPosition,sudoku)){
            return false;
        }
        return true;
    }

    public ChessmanSi(){

    }

    public ChessmanSi(int camp , ChessPosition chessPosition){
        super(camp,chessPosition, ChessStatic.CHESSMAN_TYPE_SHI);
    }
    private static int[][] stepArr = {{1,-1},{1,1},{-1,1},{-1,-1}};

    @Override
    public int[][] getStepArr(){
        return stepArr;
    }
}
