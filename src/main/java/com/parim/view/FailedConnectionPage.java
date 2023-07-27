package com.parim.view;

import com.parim.view.swingObjects.ButtonCreator;

import javax.swing.*;

public class FailedConnectionPage extends JPanel {
    private ButtonCreator tryAgain, offline;
    public FailedConnectionPage(){
        tryAgain = new ButtonCreator(400, 300, "Try Again");
        tryAgain.addActionListener(e -> MainFrame.getInstance().clickedOnTryAgain());
        this.add(tryAgain);

        offline = new ButtonCreator(650 + 200, 300, "Continue Offline");
        this.add(offline);

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }
}
