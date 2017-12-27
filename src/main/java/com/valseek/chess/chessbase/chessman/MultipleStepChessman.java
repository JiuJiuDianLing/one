package com.valseek.chess.chessbase.chessman;

import com.valseek.chess.chessbase.ChessPosition;
import com.valseek.chess.chessbase.ChessStatic;

abstract public class MultipleStepChessman extends Chessman{
    public MultipleStepChessman(){};
    public MultipleStepChessman(int camp, ChessPosition chessPosition,int chessmanType) {
        super(camp, chessPosition, chessmanType);
    }
}
