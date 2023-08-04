package com.parim.model;

import javax.swing.*;

public class Notification {
    private final int x, y;
    private JButton button;
    public Notification(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean isEmpty() {
        return button == null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }
}
