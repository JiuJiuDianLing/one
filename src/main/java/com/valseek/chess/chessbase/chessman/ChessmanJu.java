package com.valseek.chess.chessbase.chessman;

import com.valseek.chess.chessbase.ChessBoard;
import com.valseek.chess.chessbase.ChessGame;
import com.valseek.chess.chessbase.ChessPosition;
import com.valseek.chess.chessbase.ChessStatic;

import java.util.LinkedList;

public class ChessmanJu extends MultipleStepChessman {

    private static int[][] stepArr = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    protected void initLabel(int camp) {
        this.label = "車";
    }

    public ChessPosition[] getAvailablePositions() {
        LinkedList<ChessPosition> chessPositionList = new LinkedList<ChessPosition>();
        int startX = this.getChessPosition().getX();
        int startY = this.getChessPosition().getY();
        int cursorX, cursorY;
        for (int i = 0; i < stepArr.length; i++) {
            cursorX = startX;
            cursorY = startY;
            while (true) {
                cursorX += stepArr[i][0];
                cursorY += stepArr[i][1];
                if (cursorX < ChessBoard.MIN_X
                        || cursorX > ChessBoard.MAX_X
                        || cursorY < ChessBoard.MIN_Y
                        || cursorY > ChessBoard.MAX_Y
                        ) {
                    break;
                }
                Chessman positionChessman =  chessGame.getPositionChessman(cursorX,cursorY);
                if(positionChessman == null){
                    chessPositionList.add(ChessStatic.getInstance().getPosition(cursorX,cursorY));
                }else{
                    if(positionChessman.getCamp() != this.getCamp()){
                        chessPositionList.add(ChessStatic.getInstance().getPosition(cursorX,cursorY));
                    }
                    break;
                }
            }
        }
        ChessPosition[] chessPositions = new ChessPosition[chessPositionList.size()];
        chessPositionList.toArray(chessPositions);
        return chessPositions;
    }


    public ChessmanJu() {

    }

    public ChessmanJu(int camp, ChessPosition chessPosition) {
        super(camp, chessPosition, ChessStatic.CHESSMAN_TYPE_JU);
    }
}
