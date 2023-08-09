package com.parim.view.page.account;

import com.parim.view.MainFrame;
import com.parim.view.swingObjects.ButtonCreator;

import javax.swing.*;

public class AccountPage extends JPanel {
    public AccountPage(){
        ButtonCreator register = new ButtonCreator(300, "Register");
        if (MainFrame.isOfflineGame()) register.setEnabled(false);
        else register.addActionListener(e -> MainFrame.getInstance().clickedOnRegister());
        this.add(register);

        ButtonCreator login = new ButtonCreator(500, "Login");
        login.addActionListener(e -> MainFrame.getInstance().clickedOnLogin());
        this.add(login);

        if (MainFrame.isOfflineGame()){
            ButtonCreator retryConnectToServer = new ButtonCreator(900, 200, "Connect To Server");
            retryConnectToServer.addActionListener(e -> MainFrame.getInstance().clickedOnTryAgain());
            this.add(retryConnectToServer);
        }

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }
}
