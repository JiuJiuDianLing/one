package com.valseek.chess;

import com.valseek.chess.chessbase.ChessGame;
import com.valseek.chess.chessbase.ChessStep;
import com.valseek.chess.exception.ChessmanAttackException;
import com.valseek.chess.exception.ChessmanTypeException;
import com.valseek.chess.exception.FindNoButtonException;
import com.valseek.chess.view.ChessView;

import java.io.IOException;

public class Main {
    public static void main(String[] argv) throws ChessmanTypeException, ChessmanAttackException, InterruptedException, IOException , FindNoButtonException{
        ChessGame chessGame = new ChessGame();
        chessGame.init();
        ChessView chessView = new ChessView(chessGame);
        chessView.init();
        while (chessGame.getState() == ChessGame.STATE_ALIVE) {
            chessGame.outputBoard();
            System.out.println();
            System.out.println();
            ChessStep chessStep = chessGame.randomStep();
            if(chessStep == null){
                continue;
            }
            System.out.println("step. " + chessStep.getChessman().getCampStr() +
                    " 子: " + chessStep.getChessman().getLabel() +
                    " x:" + chessStep.getMoveToPosition().getX() +
                    " y:" + chessStep.getMoveToPosition().getY()
            );
            chessView.doStep(chessStep);
            chessGame.doStep(chessStep);
            System.out.println();
            System.out.println();
            chessGame.outputBoard();
            System.out.println("\n\n\n\n\n");
        }
    }
}
