package com.valseek.chess.chessbase.chessman;

import com.valseek.chess.chessbase.ChessGame;
import com.valseek.chess.chessbase.ChessPosition;
import com.valseek.chess.chessbase.ChessStatic;
import com.valseek.chess.chessbase.ChessStep;

/**
 * 棋子基类
 */
abstract public class Chessman {

    protected char color; // 棋子的颜色


    protected int camp;

    protected int type;

    protected boolean alive;
    protected ChessPosition chessPosition;
    protected String label;
    protected ChessGame chessGame;

    abstract public ChessPosition[] getAvailablePositions();
    abstract protected void initLabel(int camp);


    private void init() {
        this.initLabel(this.camp);
        this.setAlive(true);
    }

    public Chessman() {

    }

    public String getCampStr(){
        if(this.getCamp() == ChessStatic.CHESS_CAMP_RED){
            return "红";
        }else{
            return "黑";
        }
    }

    public ChessPosition[] getAttackPositions(){
        return this.getAvailablePositions();
    }

    public Chessman(int camp, ChessPosition chessPosition) {
        this.camp = camp;
        this.chessPosition = chessPosition;
        this.init();
    }

    public Chessman(int camp, ChessPosition chessPosition, int type) {
        this.camp = camp;
        this.chessPosition = chessPosition;
        this.type = type;
        this.init();
    }

    public ChessPosition getChessPosition() {
        return this.chessPosition;
    }


    public ChessPosition randomTo() {
        ChessPosition[] availablePositions = this.getAvailablePositions();
        int availablePositionNum = availablePositions.length;
        if(availablePositionNum == 0){
            return null;
        }
        int index = Double.valueOf(Math.random()*availablePositionNum).intValue();
        return availablePositions[index];
    }

    /**
     * 棋子吃子
     *
     * @param chessman
     * @return
     */
    public boolean attack(Chessman chessman) {
        //TODO 棋子吃子
        return true;
    }

    public boolean moveTo(ChessPosition chessPosition) {
        //TODO 棋子走子
        this.chessPosition = chessPosition;
        return true;
    }

    public boolean moveTo(int x, int y) {
        //TODO 棋子走子移动到某个x y
        this.chessPosition = ChessStatic.getInstance().getPosition(x,y);
        return true;
    }

    public void die() {
        // 棋子死掉
    }

    public String getLabel() {
        return this.label;
    }


    public int getCamp() {
        return camp;
    }

    public void setCamp(int camp) {
        this.camp = camp;
    }

    public ChessGame getChessGame() {
        return chessGame;
    }

    public void setChessGame(ChessGame chessGame) {
        this.chessGame = chessGame;
    }

    public boolean chessmanDie(){
        this.alive = false;
        return true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
