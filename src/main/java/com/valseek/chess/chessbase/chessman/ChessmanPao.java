package com.valseek.chess.chessbase.chessman;

import com.valseek.chess.chessbase.ChessBoard;
import com.valseek.chess.chessbase.ChessGame;
import com.valseek.chess.chessbase.ChessPosition;
import com.valseek.chess.chessbase.ChessStatic;

import java.util.LinkedList;

public class ChessmanPao extends MultipleStepChessman{

    private static int[][] stepArr = {{0,1},{0,-1},{1,0},{-1,0}};

    @Override
    protected void initLabel(int camp) {
        this.label = "炮";
    }

    public ChessmanPao(){
    }

    @Override
    public ChessPosition[] getAvailablePositions() {
        LinkedList<ChessPosition> chessPositionLinkedList = new LinkedList<ChessPosition>();
        int nx = this.getChessPosition().getX();
        int ny = this.getChessPosition().getY();
        int cursorX,cursorY;
        boolean isInterval;
        for(int i = 0 ; i< stepArr.length ; i++){
            cursorX = nx;
            cursorY = ny;
            isInterval = false;
            while(true){
                cursorX += stepArr[i][0];
                cursorY += stepArr[i][1];
                if(!ChessStatic.positionInArea(cursorX,cursorY,ChessBoard.getAllArea())){
                    break;
                }
                Chessman chessman = this.getChessGame().getPositionChessman(cursorX,cursorY);
                if(chessman == null){
                    if(!isInterval){
                        chessPositionLinkedList.add(ChessStatic.getInstance().getPosition(cursorX,cursorY));
                    }
                }else{
                    if(!isInterval){
                        isInterval = true;
                    }else{
                        if(this.getCamp() == chessman.getCamp()){
                            break;
                        }else{
                            chessPositionLinkedList.add(ChessStatic.getInstance().getPosition(cursorX,cursorY));
                        }
                    }
                }
            }
        }
        ChessPosition[] chessPositions = new ChessPosition[chessPositionLinkedList.size()];
        chessPositionLinkedList.toArray(chessPositions);
        return chessPositions;
    }

    @Override
    public ChessPosition[] getAttackPositions() {
        LinkedList<ChessPosition> chessPositionLinkedList = new LinkedList<ChessPosition>();
        int nx = this.getChessPosition().getX();
        int ny = this.getChessPosition().getY();
        int cursorX,cursorY;
        boolean isInterval;
        for(int i = 0 ; i< stepArr.length ; i++){
            cursorX = nx;
            cursorY = ny;
            isInterval = false;
            while(true){
                cursorX += stepArr[i][0];
                cursorY += stepArr[i][1];
                if(!ChessStatic.positionInArea(cursorX,cursorY,ChessBoard.getAllArea())){
                    break;
                }
                Chessman chessman = this.getChessGame().getPositionChessman(cursorX,cursorY);
                if(chessman != null){
                    if(!isInterval){
                        isInterval = true;
                    }else{
                        if(this.getCamp() == chessman.getCamp()){
                            break;
                        }else{
                            chessPositionLinkedList.add(ChessStatic.getInstance().getPosition(cursorX,cursorY));
                        }
                    }
                }
            }
        }
        ChessPosition[] chessPositions = new ChessPosition[chessPositionLinkedList.size()];
        chessPositionLinkedList.toArray(chessPositions);
        return chessPositions;
    }

    public ChessmanPao(int camp , ChessPosition chessPosition){
        super(camp,chessPosition, ChessStatic.CHESSMAN_TYPE_PAO);
    }
}
