package com.valseek.chess.chessbase.chessman;

import com.valseek.chess.chessbase.ChessBoard;
import com.valseek.chess.chessbase.ChessPosition;
import com.valseek.chess.chessbase.ChessStatic;

import java.util.ArrayList;

/**
 *  单步的棋子  比如 马 象 士 帅 卒
 */
abstract public class SingleStepChessman extends Chessman{
    private static int[][] stepArr ;

    abstract public boolean stepValid(ChessPosition moveToPosition);
    public SingleStepChessman(){}
    public SingleStepChessman(int camp, ChessPosition chessPosition,int chessmanType) {
        super(camp, chessPosition,chessmanType);
    }

    public ChessPosition[]  getAvailablePositions(){
        ArrayList<ChessPosition> availablePositions = new ArrayList<ChessPosition>();
        int[][] chessmanStepArr = this.getStepArr();
        for(int i = 0;i<chessmanStepArr.length;i++){
            int nx = this.getChessPosition().getX()+chessmanStepArr[i][0];
            int ny = this.getChessPosition().getY()+chessmanStepArr[i][1];
            if(nx < ChessBoard.MIN_X ||
                    nx > ChessBoard.MAX_X ||
                    ny> ChessBoard.MAX_Y ||
                    ny < ChessBoard.MIN_Y){
                continue;
            }
            ChessPosition chessPosition = ChessStatic.getInstance().getPosition(nx , ny );
            Chessman chessman = this.getChessGame().getPositionChessman(chessPosition.getX(),chessPosition.getY());
            if(chessman != null && chessman.getCamp() == this.getCamp()){
                continue;
            }
            if(this.stepValid(chessPosition)){
                availablePositions.add(chessPosition);
            }
        }
        ChessPosition[] chessPositions = new ChessPosition[availablePositions.size()];
        availablePositions.toArray(chessPositions);
        return chessPositions;
    }

    public int[][] getStepArr(){
        return stepArr;
    }

}
