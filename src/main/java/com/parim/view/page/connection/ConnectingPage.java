package com.parim.view.page.connection;

import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;

import javax.swing.*;
import java.awt.*;

public class ConnectingPage extends JPanel {
    public ConnectingPage(){
        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(FontLoader.titleFont);
        g.drawString("Connecting to Server...", 300, MainFrame.getHEIGHT()/2 - 100);
    }
}
