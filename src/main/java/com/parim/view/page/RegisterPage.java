package com.parim.view.page;

import com.parim.view.MainFrame;
import com.parim.view.swingObjects.ButtonCreator;
import com.parim.view.swingObjects.TextFieldCreator;

import javax.swing.*;

public class RegisterPage extends JPanel {
    public RegisterPage(){
        TextFieldCreator username = new TextFieldCreator(300, "username");
        this.add(username);

        TextFieldCreator password = new TextFieldCreator(500, "password");
        this.add(password);

        ButtonCreator next = new ButtonCreator(900, 700, "next");
        next.addActionListener(e -> nextClicked(username.getText(), password.getText()));
        this.add(next);
        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }

    private void nextClicked(String username, String password) {
        if (username.equals("username") && password.equals("password"))
            MainFrame.getInstance().defaultValueInputError();
        else if (username.equals("") || password.equals(""))
            MainFrame.getInstance().emptyValueInputError();
        else
            MainFrame.getInstance().sendRegisterMessage(username, password);
    }
}
