package com.valseek.chess.chessbase;

import com.valseek.chess.chessbase.chessman.Chessman;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class ChessPlayer {
    private int camp ;

    private ChessGame chessGame;
    private LinkedList<Chessman> chessmans;
    private int aliveChessmanNum;
    private Chessman main;

    public ChessPlayer(int camp ,ChessGame chessGame){
        this.camp = camp;
        this.chessGame = chessGame;
        this.chessmans = new LinkedList<Chessman>();
        this.aliveChessmanNum = 0;
    }

    public boolean addChessman(Chessman chessman){
        if(chessman.getType() == ChessStatic.CHESSMAN_TYPE_SHUAI){
            this.main = chessman;
        }
        this.chessmans.add(chessman);
        this.aliveChessmanNum++;
        return true;
    }

    public boolean dieChessman(Chessman chessman){
        if(chessman.getCamp() != this.camp){
            System.out.println("error die");
        }
        this.aliveChessmanNum-- ;
        chessman.chessmanDie();
        return true;
    }

    public ChessStep randomStep()
    {
        int tryTimes = 40;
        while(tryTimes -- > 0 ){
            int selectedIndex = Math.abs(new Random().nextInt()) % this.aliveChessmanNum;
//            System.out.println(selectedIndex+"\t"+this.aliveChessmanNum);
            Chessman chessman = this.getAliveChessman()[selectedIndex];
            ChessPosition chessPosition = chessman.randomTo();
            if(chessPosition == null){
                continue;
            }
            return new ChessStep(chessman,chessPosition,this.getChessGame(),this);
        }
        this.getChessGame().setState(ChessGame.STATE_END);
        return null;
    }

    public Chessman[] getAliveChessman(){
        Chessman[] aliveChessmans = new Chessman[this.aliveChessmanNum];
        int c = 0;
        ListIterator<Chessman> chessmanListIterator = this.chessmans.listIterator();
        while(chessmanListIterator.hasNext()){
            Chessman chessman = chessmanListIterator.next();
            if(chessman.isAlive()){
                if(c>=this.aliveChessmanNum){
                    System.out.println("error alive num");
                }
                aliveChessmans[c++] = chessman;
            }
        }
        if(c!=this.aliveChessmanNum){
            System.out.println();
        }
        return aliveChessmans;
    }

    public LinkedList<Chessman> getChessmans() {
        return chessmans;
    }

    public void setChessmans(LinkedList<Chessman> chessmans) {
        this.chessmans = chessmans;
    }

    public int getAliveChessmanNum() {
        return aliveChessmanNum;
    }

    public void setAliveChessmanNum(int aliveChessmanNum) {
        this.aliveChessmanNum = aliveChessmanNum;
    }

    public ChessGame getChessGame() {
        return chessGame;
    }

    public void setChessGame(ChessGame chessGame) {
        this.chessGame = chessGame;
    }
}
