package com.parim.view.swingObjects;

import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;

import javax.swing.*;
import java.awt.*;

public class ButtonCreator extends JButton {
    public ButtonCreator(int y, String text){
        this.setText(text);
        this.setFont(FontLoader.buttonFont);
        this.setBounds(MainFrame.getHEIGHT()/2 - 150, y, 300, 100);
        this.setFocusable(false);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.BOTTOM);
    }
    public ButtonCreator(int x, int y, String text){
        this.setText(text);
        this.setFont(FontLoader.buttonFont);
        this.setBounds(x, y, 300, 100);
        this.setFocusable(false);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.BOTTOM);
    }
    public ButtonCreator(int x, int y, int width, int height, String text){
        this.setText(text);
        this.setFont(FontLoader.buttonFont);
        this.setBounds(x, y, width, height);
        this.setFocusable(false);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.BOTTOM);
    }
    public ButtonCreator(int x, int y, Image image, String name, String price){
        this.setIcon(new ImageIcon(image));
        this.setText(name + " :: " + price);
        this.setBounds(x, y, 250, 350);
        this.setFont(FontLoader.notificationFont);
        this.setFocusable(false);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.BOTTOM);
    }

    public ButtonCreator(int x, int y, Image image1, Image image2, String name1, String name2, String price){
        this.setIcon(new TwoIconCreator(new ImageIcon(image1), new ImageIcon(image2)));
        this.setText(MainFrame.getInstance().createText(name1 + "\n" + name2, price));
        System.out.println(this.getText());
        this.setBounds(x, y, 250, 350);
        this.setFont(FontLoader.notificationFont);
        this.setFocusable(false);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.BOTTOM);
    }
}
