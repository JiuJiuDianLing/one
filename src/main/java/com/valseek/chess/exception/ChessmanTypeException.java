package com.valseek.chess.exception;

import java.lang.Exception;

public class ChessmanTypeException extends Exception {

    private int type = -1;

    public ChessmanTypeException(){
        super();
    }

    public ChessmanTypeException(int type){
        this.type = type;
    }

    @Override
    public String getMessage() {
        String superMessage =  super.getMessage();
        return superMessage + "the type is" + this.type;
    }
}
