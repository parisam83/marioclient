package com.parim.view.page.game;

import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;

import javax.swing.*;
import java.awt.*;

public class TimeToStartGamePage extends JPanel {
    private static int time;
    public TimeToStartGamePage(int time){
        TimeToStartGamePage.time = time;
        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(FontLoader.titleFont);
        g.drawString("Starting the game in " + time + " seconds...", 300, MainFrame.getHEIGHT()/2 - 100);
    }
}
