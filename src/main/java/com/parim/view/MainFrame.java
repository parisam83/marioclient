package com.parim.view;

import com.parim.Client;
import com.parim.client.OfflineGameClient;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static MainFrame instance;
    private static final int WIDTH = 1500, HEIGHT = 800;
    private static final Dimension DIMENSION = new Dimension(WIDTH, HEIGHT);
    public MainFrame(){
        if (instance != null) return;
        instance = this;

        this.setTitle("+++++");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(DIMENSION);
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - WIDTH/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 - HEIGHT/2);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void setConnectingPage() {
        setPage(new ConnectingPage());
    }
    public void setFailedConnectionPage(){
        setPage(new FailedConnectionPage());
    }

    private void setPage(JPanel panel) {
        this.setContentPane(panel);
        this.pack();
        /*this.setLocationRelativeTo(null);
        this.setVisible(true);
        panel.requestFocus();
        panel.setVisible(true);*/
    }

    // Getters and Setters

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static Dimension getDIMENSION() {
        return DIMENSION;
    }

    public static MainFrame getInstance() {
        return instance;
    }

    public void clickedOnTryAgain() {
        Client.getInstance().clickedOnOnlineGame();
    }
    public void clickedOnOfflineGame(){
        Client.getInstance().clickedOnOfflineGame();
    }
}
