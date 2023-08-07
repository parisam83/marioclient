package com.parim.view.swingObjects;

import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;

import javax.swing.*;
import java.awt.*;

public class LabelCreator extends JLabel {
    private int x = 0, y = 20;
    private Font font = FontLoader.titleFont;
    private final String text;

    public LabelCreator(String text) {
        this.text = text;
        createLabel();
    }
    public void createLabel(){
        this.setText(text);
        this.setFont(font);
        this.setBounds(x, y, MainFrame.getWIDTH(), MainFrame.getHEIGHT());
        this.setVerticalAlignment(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}
