package com.valseek.chess.chessbase;


import com.valseek.chess.chessbase.chessman.Chessman;
import com.valseek.chess.exception.ChessmanTypeException;

import java.util.LinkedList;

/****** 1** **** 2 ****** 3 ***** 4 ****** 5 ****** 6 ***** 7 ****** 8 ****** 9*
10------车-------马-------象------士------- 将-------士------象--------马-------车--
 *      |        |        |       |        |        |       |        |        |
 *      |        |        |       |        |        |       |        |        |
 9------  -------  -------  ------  -------  ------  -------  -------  ------  --
 *      |        |        |       |        |        |       |        |        |
 *      |        |        |       |        |        |       |        |        |
 8------  -------炮-------  ------  -------  ------  -------  -------炮------  --
 *      |        |        |       |        |        |       |        |        |
 *      |        |        |       |        |        |       |        |        |
 7------卒-------  -------卒------  -------卒------  -------卒--------  -------卒--
 *      |        |        |       |        |        |       |        |        |
 *      |        |        |       |        |        |       |        |        |
 6------  -------  -------  ------  -------  ------  -------  -------  ------  --


 5------  -------  -------  ------  -------  ------  -------  -------  ------  --
 *      |        |        |       |        |        |       |        |        |
 *      |        |        |       |        |        |       |        |        |
 4------兵-------  -------兵------  -------兵------  -------兵--------  -------兵--
 *      |        |        |       |        |        |       |        |        |
 *      |        |        |       |        |        |       |        |        |
 3------  -------炮-------  ------  -------  ------  -------  -------炮 ------  --
 *      |        |        |       |        |        |       |        |        |
 *      |        |        |       |        |        |       |        |        |
 2------  -------  -------  ------  -------  ------  -------  -------  ------  --
 *      |        |        |       |        |        |       |        |        |
 *      |        |        |       |        |        |       |        |        |
 1------车-------马-------相------士--------帅-------士------相--------马-------车--
 ****** 1** **** 2 ****** 3 ***** 4 ****** 5 ****** 6 ***** 7 ****** 8 ****** 9*
 */

public class ChessGame {

    private ChessBoard board;
    private ChessPlayer chessPlayerRed;
    private ChessPlayer chessPlayerBlack;

    /**
     *   初始象棋棋盘
     *   棋子类型 ， 棋子颜色 ， positionX ， positionY
     */
    private static int[][] gameInitArr = {
            //  ************    BLACK CAMP ****************
            {ChessStatic.CHESSMAN_TYPE_JU   , ChessStatic.CHESS_CAMP_BLACK  ,   1,  10},
            {ChessStatic.CHESSMAN_TYPE_MA   , ChessStatic.CHESS_CAMP_BLACK  ,   2,  10},
            {ChessStatic.CHESSMAN_TYPE_XIANG, ChessStatic.CHESS_CAMP_BLACK  ,   3,  10},
            {ChessStatic.CHESSMAN_TYPE_SHI   , ChessStatic.CHESS_CAMP_BLACK  ,   4,  10},
            {ChessStatic.CHESSMAN_TYPE_SHUAI, ChessStatic.CHESS_CAMP_BLACK  ,   5,  10},
            {ChessStatic.CHESSMAN_TYPE_SHI   , ChessStatic.CHESS_CAMP_BLACK  ,   6,  10},
            {ChessStatic.CHESSMAN_TYPE_XIANG, ChessStatic.CHESS_CAMP_BLACK  ,   7,  10},
            {ChessStatic.CHESSMAN_TYPE_MA   , ChessStatic.CHESS_CAMP_BLACK  ,   8,  10},
            {ChessStatic.CHESSMAN_TYPE_JU   , ChessStatic.CHESS_CAMP_BLACK  ,   9,  10},
            {ChessStatic.CHESSMAN_TYPE_PAO  , ChessStatic.CHESS_CAMP_BLACK  ,   2,  8},
            {ChessStatic.CHESSMAN_TYPE_PAO  , ChessStatic.CHESS_CAMP_BLACK  ,   8,  8},
            {ChessStatic.CHESSMAN_TYPE_ZU   , ChessStatic.CHESS_CAMP_BLACK  ,   1,  7},
            {ChessStatic.CHESSMAN_TYPE_ZU   , ChessStatic.CHESS_CAMP_BLACK  ,   3,  7},
            {ChessStatic.CHESSMAN_TYPE_ZU   , ChessStatic.CHESS_CAMP_BLACK  ,   5,  7},
            {ChessStatic.CHESSMAN_TYPE_ZU   , ChessStatic.CHESS_CAMP_BLACK  ,   7,  7},
            {ChessStatic.CHESSMAN_TYPE_ZU   , ChessStatic.CHESS_CAMP_BLACK  ,   9,  7},

            //  *************   RED CAMP    ***************
            {ChessStatic.CHESSMAN_TYPE_JU   , ChessStatic.CHESS_CAMP_RED  ,   1,  1},
            {ChessStatic.CHESSMAN_TYPE_MA   , ChessStatic.CHESS_CAMP_RED  ,   2,  1},
            {ChessStatic.CHESSMAN_TYPE_XIANG, ChessStatic.CHESS_CAMP_RED  ,   3,  1},
            {ChessStatic.CHESSMAN_TYPE_SHI   , ChessStatic.CHESS_CAMP_RED  ,   4,  1},
            {ChessStatic.CHESSMAN_TYPE_SHUAI, ChessStatic.CHESS_CAMP_RED  ,   5,  1},
            {ChessStatic.CHESSMAN_TYPE_SHI   , ChessStatic.CHESS_CAMP_RED  ,   6,  1},
            {ChessStatic.CHESSMAN_TYPE_XIANG, ChessStatic.CHESS_CAMP_RED  ,   7,  1},
            {ChessStatic.CHESSMAN_TYPE_MA   , ChessStatic.CHESS_CAMP_RED  ,   8,  1},
            {ChessStatic.CHESSMAN_TYPE_JU   , ChessStatic.CHESS_CAMP_RED  ,   9,  1},
            {ChessStatic.CHESSMAN_TYPE_PAO  , ChessStatic.CHESS_CAMP_RED  ,   2,  3},
            {ChessStatic.CHESSMAN_TYPE_PAO  , ChessStatic.CHESS_CAMP_RED  ,   8,  3},
            {ChessStatic.CHESSMAN_TYPE_ZU   , ChessStatic.CHESS_CAMP_RED  ,   1,  4},
            {ChessStatic.CHESSMAN_TYPE_ZU   , ChessStatic.CHESS_CAMP_RED  ,   3,  4},
            {ChessStatic.CHESSMAN_TYPE_ZU   , ChessStatic.CHESS_CAMP_RED  ,   5,  4},
            {ChessStatic.CHESSMAN_TYPE_ZU   , ChessStatic.CHESS_CAMP_RED  ,   7,  4},
            {ChessStatic.CHESSMAN_TYPE_ZU   , ChessStatic.CHESS_CAMP_RED  ,   9,  4}

    };

    public void init() throws ChessmanTypeException{
        //  创建棋盘
        this.board = new ChessBoard();
        // 创建棋子
        for(int  i = 0 ; i < gameInitArr.length ; i++){
            int[] chessmanArr = gameInitArr[i];
            ChessPosition chessPosition = new ChessPosition(chessmanArr[2],chessmanArr[3]);
            Chessman chessman = ChessmanFactory.createChessman(chessmanArr[0],chessmanArr[1],chessPosition);
            // 设置棋子到棋盘上
            this.board.setChessman(chessman,chessPosition);
        }
        // 创建两个下棋的人
        this.chessPlayerBlack = new ChessPlayer(ChessStatic.CHESS_CAMP_BLACK);
        this.chessPlayerRed = new ChessPlayer(ChessStatic.CHESS_CAMP_RED);

    }
}
