package com.parim.view.page;

import com.parim.view.MainFrame;
import com.parim.view.swingObjects.ButtonCreator;

import javax.swing.*;

public class AccountPage extends JPanel {
    public AccountPage(){
        ButtonCreator register = new ButtonCreator(300, "Register");
        register.addActionListener(e -> MainFrame.getInstance().clickedOnRegister());
        this.add(register);

        ButtonCreator login = new ButtonCreator(500, "Login");
        login.addActionListener(e -> MainFrame.getInstance().clickedOnLogin());
        this.add(login);

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }
}
