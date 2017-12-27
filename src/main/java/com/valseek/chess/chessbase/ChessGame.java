package com.valseek.chess.chessbase;


import com.valseek.chess.chessbase.chessman.Chessman;
import com.valseek.chess.exception.ChessmanAttackException;
import com.valseek.chess.exception.ChessmanTypeException;

import java.util.ArrayList;
import java.util.LinkedList;

/****** 1** **** 2 ****** 3 ***** 4 ****** 5 ****** 6 ***** 7 ****** 8 ****** 9*
 1------车-------马-------象------士------- 将-------士------象--------马-------车--
 *      |        |        |       |        |        |       |        |        |
 *      |        |        |       |        |        |       |        |        |
 2------  -------  -------  ------  -------  ------  -------  -------  ------  --
 *      |        |        |       |        |        |       |        |        |
 *      |        |        |       |        |        |       |        |        |
 3------  -------炮-------  ------  -------  ------  -------  -------炮------  --
 *      |        |        |       |        |        |       |        |        |
 *      |        |        |       |        |        |       |        |        |
 4------卒-------  -------卒------  -------卒------  -------卒--------  -------卒--
 *      |        |        |       |        |        |       |        |        |
 *      |        |        |       |        |        |       |        |        |
 5------  -------  -------  ------  -------  ------  -------  -------  ------  --


 6------  -------  -------  ------  -------  ------  -------  -------  ------  --
 *      |        |        |       |        |        |       |        |        |
 *      |        |        |       |        |        |       |        |        |
 7------兵-------  -------兵------  -------兵------  -------兵--------  -------兵--
 *      |        |        |       |        |        |       |        |        |
 *      |        |        |       |        |        |       |        |        |
 8------  -------炮-------  ------  -------  ------  -------  -------炮 ------  --
 *      |        |        |       |        |        |       |        |        |
 *      |        |        |       |        |        |       |        |        |
 9------  -------  -------  ------  -------  ------  -------  -------  ------  --
 *      |        |        |       |        |        |       |        |        |
 *      |        |        |       |        |        |       |        |        |
 10------车-------马-------相------士--------帅-------士------相--------马-------车--
 ****** 1** **** 2 ****** 3 ***** 4 ****** 5 ****** 6 ***** 7 ****** 8 ****** 9*
 */

public class ChessGame {
    public static int STATE_END = 2;
    public static int STATE_ALIVE = 1;
    public static int STATE_INFINITE = 0;

    private ChessBoard board;               // 棋盘

    private ChessPlayer chessPlayerRed;     // 红玩家
    private ChessPlayer chessPlayerBlack;   // 黑玩家
    private int state;                     // 状态 进行中 输赢
    private ChessPlayer executor;           // 执行者

    public static int RED_TO_BLACK_Y = -1;
    public static int BLACK_TO_RED_Y = 1;

    private ArrayList<ChessStep> chessSteps ;

    public ChessGame() {
        this.state = 1;
    }

    /**
     * 初始象棋棋盘
     * 棋子类型 ， 棋子颜色 ， positionX ， positionY
     */
    private static int[][] gameInitArr = {
            //  ************    RED CAMP ****************
            {ChessStatic.CHESSMAN_TYPE_JU, ChessStatic.CHESS_CAMP_RED, 1, 10},
            {ChessStatic.CHESSMAN_TYPE_MA, ChessStatic.CHESS_CAMP_RED, 2, 10},
            {ChessStatic.CHESSMAN_TYPE_XIANG, ChessStatic.CHESS_CAMP_RED, 3, 10},
            {ChessStatic.CHESSMAN_TYPE_SHI, ChessStatic.CHESS_CAMP_RED, 4, 10},
            {ChessStatic.CHESSMAN_TYPE_SHUAI, ChessStatic.CHESS_CAMP_RED, 5, 10},
            {ChessStatic.CHESSMAN_TYPE_SHI, ChessStatic.CHESS_CAMP_RED, 6, 10},
            {ChessStatic.CHESSMAN_TYPE_XIANG, ChessStatic.CHESS_CAMP_RED, 7, 10},
            {ChessStatic.CHESSMAN_TYPE_MA, ChessStatic.CHESS_CAMP_RED, 8, 10},
            {ChessStatic.CHESSMAN_TYPE_JU, ChessStatic.CHESS_CAMP_RED, 9, 10},
            {ChessStatic.CHESSMAN_TYPE_PAO, ChessStatic.CHESS_CAMP_RED, 2, 8},
            {ChessStatic.CHESSMAN_TYPE_PAO, ChessStatic.CHESS_CAMP_RED, 8, 8},
            {ChessStatic.CHESSMAN_TYPE_ZU, ChessStatic.CHESS_CAMP_RED, 1, 7},
            {ChessStatic.CHESSMAN_TYPE_ZU, ChessStatic.CHESS_CAMP_RED, 3, 7},
            {ChessStatic.CHESSMAN_TYPE_ZU, ChessStatic.CHESS_CAMP_RED, 5, 7},
            {ChessStatic.CHESSMAN_TYPE_ZU, ChessStatic.CHESS_CAMP_RED, 7, 7},
            {ChessStatic.CHESSMAN_TYPE_ZU, ChessStatic.CHESS_CAMP_RED, 9, 7},

            //  *************  BLACK CAMP    ***************
            {ChessStatic.CHESSMAN_TYPE_JU, ChessStatic.CHESS_CAMP_BLACK, 1, 1},
            {ChessStatic.CHESSMAN_TYPE_MA, ChessStatic.CHESS_CAMP_BLACK, 2, 1},
            {ChessStatic.CHESSMAN_TYPE_XIANG, ChessStatic.CHESS_CAMP_BLACK, 3, 1},
            {ChessStatic.CHESSMAN_TYPE_SHI, ChessStatic.CHESS_CAMP_BLACK, 4, 1},
            {ChessStatic.CHESSMAN_TYPE_SHUAI, ChessStatic.CHESS_CAMP_BLACK, 5, 1},
            {ChessStatic.CHESSMAN_TYPE_SHI, ChessStatic.CHESS_CAMP_BLACK, 6, 1},
            {ChessStatic.CHESSMAN_TYPE_XIANG, ChessStatic.CHESS_CAMP_BLACK, 7, 1},
            {ChessStatic.CHESSMAN_TYPE_MA, ChessStatic.CHESS_CAMP_BLACK, 8, 1},
            {ChessStatic.CHESSMAN_TYPE_JU, ChessStatic.CHESS_CAMP_BLACK, 9, 1},
            {ChessStatic.CHESSMAN_TYPE_PAO, ChessStatic.CHESS_CAMP_BLACK, 2, 3},
            {ChessStatic.CHESSMAN_TYPE_PAO, ChessStatic.CHESS_CAMP_BLACK, 8, 3},
            {ChessStatic.CHESSMAN_TYPE_ZU, ChessStatic.CHESS_CAMP_BLACK, 1, 4},
            {ChessStatic.CHESSMAN_TYPE_ZU, ChessStatic.CHESS_CAMP_BLACK, 3, 4},
            {ChessStatic.CHESSMAN_TYPE_ZU, ChessStatic.CHESS_CAMP_BLACK, 5, 4},
            {ChessStatic.CHESSMAN_TYPE_ZU, ChessStatic.CHESS_CAMP_BLACK, 7, 4},
            {ChessStatic.CHESSMAN_TYPE_ZU, ChessStatic.CHESS_CAMP_BLACK, 9, 4}

    };

    public void init() throws ChessmanTypeException {
        //  创建棋盘
        this.board = new ChessBoard();

        // 创建两个下棋的人
        this.chessPlayerBlack = new ChessPlayer(ChessStatic.CHESS_CAMP_BLACK, this);
        this.chessPlayerRed = new ChessPlayer(ChessStatic.CHESS_CAMP_RED, this);

        // 创建棋子
        for (int i = 0; i < gameInitArr.length; i++) {
            int[] chessmanArr = gameInitArr[i];
            ChessPosition chessPosition = ChessStatic.getInstance().getPosition(chessmanArr[2], chessmanArr[3]);
            Chessman chessman = ChessmanFactory.createChessman(chessmanArr[0], chessmanArr[1], chessPosition);
            // 设置棋子到棋盘上
            this.board.setChessman(chessman, chessPosition);
            chessman.setChessGame(this);
            if (chessmanArr[1] == ChessStatic.CHESS_CAMP_RED) {
                this.chessPlayerRed.addChessman(chessman);
            } else {
                this.chessPlayerBlack.addChessman(chessman);
            }
        }
        this.executor = this.chessPlayerRed;
        this.chessSteps = new ArrayList<ChessStep>();
    }

    public ChessPlayer getEnemy(int camp) {
        if (camp == ChessStatic.CHESS_CAMP_BLACK) {
            return this.chessPlayerRed;
        } else if (camp == ChessStatic.CHESS_CAMP_RED) {
            return this.chessPlayerBlack;
        }
        return null;
    }

    public void outputBoard(){
        for(int i = 1 ; i < 11 ; i++){
            for(int j = 1 ; j < 10 ; j++){
                Chessman chessman = this.getPositionChessman(j,i);
                if(chessman != null){
                    if(chessman.getCamp() == ChessStatic.CHESS_CAMP_RED){
                        System.out.print(chessman.getLabel()+"*");
                    }else{
                        System.out.print(chessman.getLabel());
                    }
                }else{
                    System.out.print("*");
                }
                System.out.print('\t');
            }
            System.out.println();
        }
    }

    public boolean doStep(ChessStep chessStep) throws ChessmanAttackException{
        ChessPosition moveToPosition = chessStep.getMoveToPosition();
        Chessman chessman = chessStep.getChessman();
        this.setPositionChessman(chessman.getChessPosition(),null);
        Chessman moveToChessman = this.getPositionChessman(moveToPosition);
        ChessPlayer chessPlayer = chessStep.getExecutor();
        ChessPlayer nextExecutor = this.nextExecutor();
        if(moveToChessman == null){
            chessman.moveTo(moveToPosition);
        }else{
            if(moveToChessman.getCamp() == chessman.getCamp()){
                throw new ChessmanAttackException("this chessman attack error");
            }
            nextExecutor.dieChessman(moveToChessman);
            if(moveToChessman.getType() == ChessStatic.CHESSMAN_TYPE_SHUAI){
                this.state = STATE_END;
            }
        }
        this.setPositionChessman(moveToPosition,chessman);
        this.executor = nextExecutor;
        return true;
    }

    public ChessStep randomStep() {
        return this.executor.randomStep();
    }

    public ChessPlayer nextExecutor() {
        if(this.executor == this.chessPlayerRed){
            return chessPlayerBlack;
        }else if(this.executor == this.chessPlayerBlack){
            return chessPlayerRed;
        }
        return null;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Chessman getPositionChessman(int x, int y) {
        Chessman chessman = this.board.getPositionChessman(x, y);
        if(chessman == null){
            return chessman;
        }
        if(!chessman.isAlive()){
            System.out.println("get error chessman");
        }
        return chessman;
    }

    public Chessman getPositionChessman(ChessPosition chessPosition){
        Chessman chessman =  this.board.getPositionChessman(chessPosition.getX(),chessPosition.getY());
        if(chessman == null){
            return chessman;
        }
        if(!chessman.isAlive()){
            System.out.println("get error chessman");
        }
        return chessman;
    }

    public boolean setPositionChessman(ChessPosition chessPosition,Chessman chessman){
        if(chessman != null){
            chessman.moveTo(chessPosition);
        }
        return this.board.setPositionChessman(chessPosition,chessman);
    }

    public ChessPlayer getChessPlayerRed() {
        return chessPlayerRed;
    }

    public void setChessPlayerRed(ChessPlayer chessPlayerRed) {
        this.chessPlayerRed = chessPlayerRed;
    }

    public ChessPlayer getChessPlayerBlack() {
        return chessPlayerBlack;
    }

    public void setChessPlayerBlack(ChessPlayer chessPlayerBlack) {
        this.chessPlayerBlack = chessPlayerBlack;
    }

}
