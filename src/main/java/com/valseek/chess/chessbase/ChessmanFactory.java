package com.valseek.chess.chessbase;

import com.valseek.chess.chessbase.chessman.*;
import com.valseek.chess.exception.ChessmanTypeException;

public class ChessmanFactory {
    public static Chessman createChessman(int type , int camp , ChessPosition chessPosition)throws ChessmanTypeException{
        Chessman chessman = null;
        switch (type){
            case ChessStatic.CHESSMAN_TYPE_JU :
                chessman = new ChessmanJu(camp,chessPosition);
                break;
            case ChessStatic.CHESSMAN_TYPE_MA:
                chessman = new ChessmanMa(camp,chessPosition);
                break;
            case ChessStatic.CHESSMAN_TYPE_XIANG:
                chessman = new ChessmanXiang(camp,chessPosition);
                break;
            case ChessStatic.CHESSMAN_TYPE_SHI:
                chessman = new ChessmanSi(camp,chessPosition);
                break;
            case ChessStatic.CHESSMAN_TYPE_SHUAI:
                chessman = new ChessmanShuai(camp,chessPosition);
                break;
            case ChessStatic.CHESSMAN_TYPE_PAO:
                chessman = new ChessmanPao(camp,chessPosition);
                break;
            case ChessStatic.CHESSMAN_TYPE_ZU:
                chessman = new ChessmanZu(camp,chessPosition);
                break;
            default:
                throw new ChessmanTypeException();
        }
        return chessman;
    }
    public static Chessman createChessman(int type) throws ChessmanTypeException,Exception{
        Chessman chessman = null;
        switch (type){
            case ChessStatic.CHESSMAN_TYPE_JU :
                chessman = new ChessmanJu();
                break;
            case ChessStatic.CHESSMAN_TYPE_MA:
                chessman = new ChessmanMa();
                break;
            case ChessStatic.CHESSMAN_TYPE_XIANG:
                chessman = new ChessmanXiang();
                break;
            case ChessStatic.CHESSMAN_TYPE_SHI:
                chessman = new ChessmanSi();
                break;
            case ChessStatic.CHESSMAN_TYPE_SHUAI:
                chessman = new ChessmanShuai();
                break;
            case ChessStatic.CHESSMAN_TYPE_PAO:
                chessman = new ChessmanPao();
                break;
            case ChessStatic.CHESSMAN_TYPE_ZU:
                chessman = new ChessmanZu();
                break;
            default:
                Exception e = new ChessmanTypeException();
                throw e;
        }
        return chessman;
    }
}
