package com.parim.view.page.game;

import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;

import javax.swing.*;
import java.awt.*;

public class GamePage extends JPanel {
    public GamePage(){
        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(FontLoader.titleFont);
        g.drawString("TADAAAA! This is the mario game :')", 300, MainFrame.getHEIGHT()/2 - 100);
    }
}
