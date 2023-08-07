package com.parim.view;

import com.parim.Client;
import com.parim.client.OnlineGameClient;
import com.parim.event.ChatListEvent;
import com.parim.event.ItemEvent;
import com.parim.model.Chat;
import com.parim.model.User;
import com.parim.view.page.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private static MainFrame instance;
    private static final int WIDTH = 1500, HEIGHT = 800;
    private static final Dimension DIMENSION = new Dimension(WIDTH, HEIGHT);
    private ShopPage shopPage;
    private ChatPage chatPage;
    private ListOfBlockedUsernamesPage listOfBlockedUsernamesPage;
    private String onChatWith;
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
    public void setNotificationsPage(){
        setPage(new NotificationsPage());
    }
    public void setScoreboardPage(){
        setPage(new ScoreboardPage());
    }
    public void setOnlineScoreboardPage(){
        // TODO
    }
    public void setOfflineScoreboardPage(){
        // TODO
    }
    public void setShopPage(){
        setPage(shopPage = new ShopPage());
    }
    public void setChatPage(){
        setPage(chatPage = new ChatPage());
    }
    public void setPVChatPage(String me, String theOther, ArrayList<String> messages){
        setPage(new PVChatPage(me, theOther, messages));
    }
    public void setListOfBlockedUsernamesPage(){
        OnlineGameClient.getInstance().requestListOfBlockedUsernames();
        setPage(listOfBlockedUsernamesPage = new ListOfBlockedUsernamesPage());
    }

    private void setPage(JPanel panel) {
        panel.setVisible(true);
        panel.repaint();
        panel.revalidate();
        this.setContentPane(panel);
        this.repaint();
        this.revalidate();
        this.pack();
    }
    public void showBlockedUsernames(ArrayList<String> blockedUsernames){
        listOfBlockedUsernamesPage.showBlockedUsernames(blockedUsernames);
        listOfBlockedUsernamesPage.repaint();
        listOfBlockedUsernamesPage.revalidate();
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

    public void setOnChatWith(String onChatWith) {
        this.onChatWith = onChatWith;
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
    public void requestUserMessages(String username){
        onChatWith = username;
        System.out.println(onChatWith);
        OnlineGameClient.getInstance().requestUserMessages(username);
    }
    public void blockUser(String username){
        OnlineGameClient.getInstance().sendBlockUserEvent(username);
    }
    public void unblockUser(String username){
        OnlineGameClient.getInstance().sendUnblockUserEvent(username);
    }
    public void sendChatListRequest(){
        Client.getInstance().sendChatListRequest();
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
    public void getItems(){
        Client.getInstance().sendGetItemsMessage();
    }
    public void sendBuyItemMessage(String itemName){
        Client.getInstance().sendBuyItemMessage(itemName);
    }

    public void receivedRegisterResult(String result) {
        if (result.equals("no")) unsuccessfulRegisterError();
        else setMenuPage();
    }
    public void receivedLoginResult(String result) {
        if (result.equals("no")) unsuccessfulLoginError();
        else setMenuPage();
    }
    public void receivedItemEvent(ItemEvent itemEvent){
        shopPage.loadShop(itemEvent);
        shopPage.repaint();
        shopPage.revalidate();
    }
    public void receivedComboItemEvent(ItemEvent itemEvent){
        shopPage.loadCombo(itemEvent);
        shopPage.repaint();
        shopPage.revalidate();
    }
    public void receivedChatListEvent(ChatListEvent chatListEvent){
        System.out.println("receivedChatListEvent");
        System.out.println(chatListEvent.getChatList());
        chatPage.loadChatList(chatListEvent.getChatList());
        chatPage.repaint();
        chatPage.revalidate();
    }
    public void receivedMessageEvent(Chat chat){
        System.out.println(chat.getUsername1() + ", " + chat.getUsername2());
        System.out.println("onchatwith " + onChatWith);
        if (onChatWith == null) return;
        if (onChatWith.equals(chat.getUsername1()))
            setPVChatPage(chat.getUsername2(), chat.getUsername1(), chat.getMessages());
        else if (onChatWith.equals(chat.getUsername2()))
            setPVChatPage(chat.getUsername1(), chat.getUsername2(), chat.getMessages());
    }
    public void sendMessage(String sender, String receiver, String message){
        Client.getInstance().sendMessage(sender, receiver, message);
    }

    public static boolean isOfflineGame(){
        return Client.getInstance().isOfflineGame();
    }
    public String createText(String title, String message){
        String joinedText = title + "\n" + message;
        return "<html>" + joinedText.replaceAll("\\n", "<br>") + "</html>";
    }
}
