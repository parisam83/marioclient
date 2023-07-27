package com.parim.view.swingObjects;

import com.parim.view.loaders.FontLoader;

import javax.swing.*;

public class ButtonCreator extends JButton {
    public ButtonCreator(int x, int y, String text){
        this.setText(text);
        this.setFont(FontLoader.buttonFont);
        this.setBounds(x, y, 300, 100);
        this.setFocusable(false);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.BOTTOM);
    }
}
