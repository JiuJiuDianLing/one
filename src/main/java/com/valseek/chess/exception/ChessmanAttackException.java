package com.valseek.chess.exception;

public class ChessmanAttackException extends Exception{

    private String msg;

    public ChessmanAttackException(String msg){
        this.msg = msg;
    }
}
