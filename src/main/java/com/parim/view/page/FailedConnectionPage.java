package com.parim.view.page;

import com.parim.view.MainFrame;
import com.parim.view.swingObjects.ButtonCreator;

import javax.swing.*;

public class FailedConnectionPage extends JPanel {
    public FailedConnectionPage(){
        ButtonCreator tryAgain = new ButtonCreator(400, 300, "Try Again");
        tryAgain.addActionListener(e -> MainFrame.getInstance().clickedOnTryAgain());
        this.add(tryAgain);

        ButtonCreator offline = new ButtonCreator(650 + 200, 300, "Continue Offline");
        offline.addActionListener(e -> MainFrame.getInstance().clickedOnOfflineGame());
        this.add(offline);

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }
}
