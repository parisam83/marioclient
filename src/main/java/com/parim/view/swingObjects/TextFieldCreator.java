package com.parim.view.swingObjects;

import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextFieldCreator extends JTextField implements FocusListener {
    public TextFieldCreator(int y, String text){
        this.setText(text);
        this.setBounds(MainFrame.getWIDTH() /2 - 350/2, y, 350, 120);
        this.setFont(FontLoader.buttonFont);
        this.setHorizontalAlignment(JTextField.CENTER);
        this.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        this.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {}
}
