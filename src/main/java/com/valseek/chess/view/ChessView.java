package com.valseek.chess.view;

import com.valseek.chess.chessbase.ChessGame;
import com.valseek.chess.chessbase.ChessStatic;
import com.valseek.chess.chessbase.ChessStep;
import com.valseek.chess.exception.FindNoButtonException;

import javax.swing.*;
import java.awt.*;

public class ChessView {

    private ChessGame chessGame;
    private JPanel jpBoard;
    private ChessPanel jpChessman;

    public ChessView(){};

    public ChessView(ChessGame chessGame){
        this.chessGame = chessGame;
    }

    public ChessGame getChessGame() {
        return chessGame;
    }

    public void setChessGame(ChessGame chessGame) {
        this.chessGame = chessGame;
    }

    public void repaintChess(){
        this.jpChessman.removeAll();
        this.jpChessman.addChessman();
        this.jpChessman.repaint();
    }

    public void doStep(ChessStep chessStep) throws InterruptedException , FindNoButtonException{
        this.jpChessman.doStep(chessStep);
    }

    public void init()
    {
        JFrame jFrame = new JFrame();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int sh = dimension.height;
        int sw = dimension.width;
        int fh = Double.valueOf(sh*0.9).intValue();
        int fw = fh;
        int left = sw/2 - fw/2;
        int top = sh/2 - fh/2;
        jFrame.setLocation(left,top);
        jFrame.setSize(fw,fh);
        ChessPanel cp = new ChessPanel(this.chessGame);
        jFrame.add(cp);
        ChessBoardPanel cbp = new ChessBoardPanel();
        cbp.setOpaque(false);
        jFrame.add(cbp);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.jpBoard = cbp;
        this.jpChessman = cp;
        cbp.setSize(fw,fh);
        cbp.setLocation(0,0);
        cp.setSize(fw,fh);
        cp.setLocation(0,0);
        cp.setOpaque(false);
        cp.addChessman();
        cbp.repaint();
        cp.repaint();
    }

    public static void drowTestChess(ChessGame chessGame)
    {
        JFrame jFrame = new JFrame();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int sh = dimension.height;
        int sw = dimension.width;
        int fh = Double.valueOf(sh*0.9).intValue();
        int fw = fh;
        int left = sw/2 - fw/2;
        int top = sh/2 - fh/2;
        jFrame.setLocation(left,top);
        jFrame.setSize(fw,fh);
        ChessPanel cp = new ChessPanel(chessGame);
        jFrame.add(cp);
        ChessBoardPanel cbp = new ChessBoardPanel();
        cbp.setOpaque(false);
        jFrame.add(cbp);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cbp.setSize(fw,fh);
        cbp.setLocation(0,0);
        cp.setSize(fw,fh);
        cp.setLocation(0,0);
        cp.setOpaque(false);
        cp.addChessman();
        cbp.repaint();
        cp.repaint();
        try{
            cp.removeAll();
            Thread.sleep(3000);
            System.out.println("repaint");
            cp.addChessman();
            cp.repaint();
        }catch (InterruptedException e){

        }
    }

}
