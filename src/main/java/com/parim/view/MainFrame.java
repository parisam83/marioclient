package com.parim.view;

import com.parim.Client;
import com.parim.model.User;
import com.parim.view.page.*;

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
    public void setAccountPage(){
        setPage(new AccountPage());
    }
    private void setRegisterPage(){
        setPage(new RegisterPage());
    }
    private void setLoginPage(){
        setPage(new LoginPage());
    }
    public void setMenuPage() {
        setPage(new MenuPage());
    }

    private void setPage(JPanel panel) {
        this.setContentPane(panel);
        this.pack();
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
        Client.getInstance().clickedOnTryConnectingToServer();
    }
    public void clickedOnOfflineGame(){
        Client.getInstance().clickedOnOfflineGame();
    }

    public void clickedOnRegister() {
        setRegisterPage();
    }
    public void clickedOnLogin(){
        setLoginPage();
    }

    // Errors for login
    public void emptyValueInputError(){
        JOptionPane.showMessageDialog(this, "You cannot set your username or password empty!", "EmptyValueInputError", JOptionPane.ERROR_MESSAGE);
    }
    public void defaultValueInputError(){
        JOptionPane.showMessageDialog(this, "You cannot set your username and password as their default value!", "DefaultValueInputError", JOptionPane.ERROR_MESSAGE);
    }
    public void unsuccessfulLoginError(){
        JOptionPane.showMessageDialog(this, "Username or password is not correct!", "UnsuccessfulLoginError", JOptionPane.ERROR_MESSAGE);
    }
    public void unsuccessfulRegisterError(){
        JOptionPane.showMessageDialog(this, "This username is taken. Please try another username.", "UnsuccessfulRegisterError", JOptionPane.ERROR_MESSAGE);
    }

    public void sendRegisterMessage(User user) {
        Client.getInstance().sendRegisterMessage(user);
    }
    public void sendLoginMessage(User user) {
        Client.getInstance().sendLoginMessage(user);
    }

    public void receivedRegisterResult(String result) {
        if (result.equals("no")) unsuccessfulRegisterError();
        else setMenuPage();
    }
    public void receivedLoginResult(String result) {
        if (result.equals("no")) unsuccessfulLoginError();
        else setMenuPage();
    }
    public static boolean isOfflineGame(){
        return Client.getInstance().isOfflineGame();
    }
}
