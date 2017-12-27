package com.valseek.chess.chessbase.chessman;

import com.valseek.chess.chessbase.*;

public class ChessmanShuai extends SingleStepChessman{

    private static int[][] stepArr= {{1,0},{-1,0},{0,1},{0,-1}};

    @Override
    protected void initLabel(int camp) {
        if(camp == ChessStatic.CHESS_CAMP_RED){
            this.label="帅";
        }else{
            this.label = "将";
        }
    }

    @Override
    public boolean stepValid(ChessPosition moveToPosition) {
        int[] sudokuArea = ChessBoard.getSudoku(this.getCamp());
        if(!ChessStatic.positionInArea(moveToPosition,sudokuArea)){
            return false;
        }
        // 判断 他妈的别被干掉了
        ChessPlayer enemyPlayer = this.getChessGame().getEnemy(this.getCamp());
        Chessman[] enemyChessmans = enemyPlayer.getAliveChessman();
        Chessman enemyChessman = null;
        Chessman moveToChessman = this.getChessGame().getPositionChessman(moveToPosition.getX(),moveToPosition.getY());
        this.getChessGame().setPositionChessman(moveToPosition,null);
        for(int i = 0 ;i<enemyChessmans.length ; i++){
            enemyChessman = enemyChessmans[i];
            if(enemyChessman.getType() == this.getType()){
                // 避免无穷递归
                continue;
            }
            ChessPosition[] chessPositions = enemyChessman.getAttackPositions();
            for(int j = 0 ; j<chessPositions.length ;j++){
                ChessPosition attackPosition = chessPositions[j];
                if(moveToPosition.getX() == attackPosition.getX() && moveToPosition.getY() == attackPosition.getY()){
                    return false;
                }
            }
        }
        this.getChessGame().setPositionChessman(moveToPosition,moveToChessman);
        // 判断 老将别请酒 了
        int ny = moveToPosition.getY();
        int nx = moveToPosition.getX();
        int addY = this.getCamp() == ChessStatic.CHESS_CAMP_RED ? ChessGame.RED_TO_BLACK_Y : ChessGame.BLACK_TO_RED_Y;
        while(true){
            ny += addY;
            if(ny < ChessBoard.MIN_Y || ny > ChessBoard.MAX_Y){
                break;
            }
            if(this.getChessGame().getPositionChessman(nx,ny) == null){
                continue;
            }
            if(this.getChessGame().getPositionChessman(nx,ny).getType() == this.getType()){
                return false;
            }
            break;
        }
        return true;
    }

    public ChessmanShuai(){

    }

    public ChessmanShuai(int camp , ChessPosition chessPosition){
        super(camp,chessPosition, ChessStatic.CHESSMAN_TYPE_SHUAI);
    }

    @Override
    public int[][] getStepArr(){
        return stepArr;
    }
}
