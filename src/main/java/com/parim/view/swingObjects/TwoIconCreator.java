package com.parim.view.swingObjects;

import javax.swing.*;
import java.awt.*;

public class TwoIconCreator implements Icon {
    private final int iconGap = 2;
    private final Icon icon1;
    private final Icon icon2;

    public TwoIconCreator(final Icon icon1, final Icon icon2) {
        this.icon1 = icon1;
        this.icon2 = icon2;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        int mid = getIconHeight() / 2;
        int y1 = y + mid - icon1.getIconHeight() / 2;
        int y2 = y + mid - icon2.getIconHeight() / 2;
        icon1.paintIcon(c, g, x, y1);
        icon2.paintIcon(c, g, x + icon1.getIconWidth() + iconGap, y2);
    }

    @Override
    public int getIconWidth() {
        return icon1.getIconWidth() + icon2.getIconWidth() + iconGap;
    }

    @Override
    public int getIconHeight() {
        return Math.max(icon1.getIconHeight(), icon2.getIconHeight());
    }
}
