package com.valseek.chess.chessbase;

import com.valseek.chess.chessbase.chessman.Chessman;

public class ChessStep {

    public Chessman getChessman() {
        return chessman;
    }

    public void setChessman(Chessman chessman) {
        this.chessman = chessman;
    }

    public ChessPosition getMoveToPosition() {
        return moveToPosition;
    }

    public void setMoveToPosition(ChessPosition moveToPosition) {
        this.moveToPosition = moveToPosition;
    }

    public ChessGame getChessGame() {
        return chessGame;
    }

    public void setChessGame(ChessGame chessGame) {
        this.chessGame = chessGame;
    }

    public ChessPlayer getExecutor() {
        return executor;
    }

    public void setExecutor(ChessPlayer executor) {
        this.executor = executor;
    }

    private Chessman chessman;
    private ChessPosition moveToPosition;
    private ChessGame chessGame;
    private ChessPlayer executor;

    public ChessStep(Chessman chessman,ChessPosition moveToPosition,ChessGame chessGame,ChessPlayer executor){
        this.chessman = chessman;
        this.moveToPosition = moveToPosition;
        this.chessGame = chessGame;
        this.executor = executor;
    }

}
