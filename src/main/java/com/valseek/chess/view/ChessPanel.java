package com.valseek.chess.view;

import com.valseek.chess.chessbase.ChessGame;
import com.valseek.chess.chessbase.ChessStatic;
import com.valseek.chess.chessbase.ChessStep;
import com.valseek.chess.chessbase.chessman.Chessman;
import com.valseek.chess.exception.ChessmanTypeException;
import com.valseek.chess.exception.FindNoButtonException;

import javax.swing.*;
import java.awt.*;

public class ChessPanel extends JPanel{

    private ChessGame chessGame;

    public ChessPanel(ChessGame chessGame){
        this.chessmanButtons = new ChessmanButton[11][10];
        this.chessGame = chessGame;
    }
    public ChessPanel(){ }

    private ChessmanButton[][] chessmanButtons;

    public void doStep(ChessStep chessStep) throws InterruptedException , FindNoButtonException{
        int fx = chessStep.getChessman().getChessPosition().getX();
        int fy = chessStep.getChessman().getChessPosition().getY();
        int tx = chessStep.getMoveToPosition().getX();
        int ty = chessStep.getMoveToPosition().getY();

        int gapx = this.getWidth()/10;
        int gapy = this.getHeight()/11;

        int bw = Double.valueOf(gapx*0.7).intValue();
        int bh = Double.valueOf(gapy*0.7).intValue();

        ChessmanButton cb = this.chessmanButtons[fy][fx];
        if(cb == null){
            throw new FindNoButtonException();
        }
        ChessmanButton cmb = this.chessmanButtons[ty][tx];
        this.chessmanButtons[fy][fx] = null;
        this.chessmanButtons[ty][tx]=cb;

        fx = fx*gapx  - bw/2;
        fy = fy*gapy - bh/2;
        tx = tx*gapx - bw/2;
        ty = ty*gapy - bh/2;

        int cx,cy;
        int nStep = 25;
        for(int i = 1 ;i<= nStep;i++){
            cx = i*(tx-fx)/nStep + fx;
            cy = i*(ty-fy)/nStep + fy;
            cb.setLocation(cx,cy);
            if(i==nStep/2 && cmb != null){
                this.remove(cmb);
            }
            Thread.sleep(3);
        }
        this.repaint();
    }

    public boolean addChessman()
    {
        int gapx = this.getWidth()/10;
        int gapy = this.getHeight()/11;
        Chessman[][] chessmanMap = this.chessGame.getBoard().getBoard();
        int bw = Double.valueOf(gapx*0.7).intValue();
        int bh = Double.valueOf(gapy*0.7).intValue();
        int cnt = 2;
        Font font = new Font("楷体", Font.BOLD, 24);
        Color red = new Color(255,0,0);
        Color black = new Color(0,0,0);
        for(int i = 1; i<chessmanMap.length;i++){
            for(int j = 1 ; j<chessmanMap[i].length ; j++){
                Chessman chessman = chessmanMap[i][j];
                if(chessman == null){
                    continue;
                }
                int left = chessman.getChessPosition().getX()*gapx  - bw/2;
                int top = chessman.getChessPosition().getY()*gapy - bh/2;
                ChessmanButton cb = new ChessmanButton();
                this.chessmanButtons[i][j] = cb;
                cb.setText(chessman.getLabel());
                cb.setBackground(new Color(204,204,153));
                if(chessman.getCamp() == ChessStatic.CHESS_CAMP_RED){
                    cb.setForeground(red);
                }else{
                    cb.setForeground(black);
                }
                cb.setFont(font);
                cb.setSize(bw,bh);
                cb.setLocation(left,top);
                cb.setOpaque(true);
                this.add(cb);
            }
        }
        return true;
    }
}
