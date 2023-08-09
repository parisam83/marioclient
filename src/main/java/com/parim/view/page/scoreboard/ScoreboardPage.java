package com.parim.view.page.scoreboard;

import com.parim.view.MainFrame;
import com.parim.view.swingObjects.ButtonCreator;

import javax.swing.*;

public class ScoreboardPage extends JPanel {
    public ScoreboardPage(){
        ButtonCreator online = new ButtonCreator(400, 300, "Online ScoreBoard");
        online.addActionListener(e -> MainFrame.getInstance().setOnlineScoreboardPage());
        this.add(online);

        ButtonCreator offline = new ButtonCreator(650 + 200, 300, "Offline ScoreBoard");
        offline.addActionListener(e -> MainFrame.getInstance().setOfflineScoreboardPage());
        this.add(offline);

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }
}
