package com.valseek.chess.view;

import javax.swing.*;
import java.awt.*;

public class ChessBoardPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
        int gapx = this.getWidth()/10;
        int gapy = this.getHeight()/11;
        // 画横线
        for(int i=1;i<=10;i++){
            g.drawLine(gapx,i*gapy,9*gapx,i*gapy);
        }
        // 画竖线
        for(int i=1;i<=9;i++){
            g.drawLine(i*gapx,gapy,i*gapx,5*gapy);
            g.drawLine(i*gapx,6*gapy,i*gapx,10*gapy);
            if(i==1 || i==9){
                g.drawLine(i*gapx,gapy,i*gapx,10*gapy);
            }
        }
        // 画 斜线
        g.drawLine(gapx*4,gapy,gapx*6,gapy*3);
        g.drawLine(gapx*4,gapy*8,gapx*6,gapy*10);
        g.drawLine(gapx*4,gapy*3,gapx*6,gapy);
        g.drawLine(gapx*4,gapy*10,gapx*6,gapy*8);
    }
}
