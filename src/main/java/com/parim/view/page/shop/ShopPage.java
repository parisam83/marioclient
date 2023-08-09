package com.parim.view.page.shop;

import com.parim.event.shop.ItemEvent;
import com.parim.event.shop.UserShopEvent;
import com.parim.model.Item;
import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;
import com.parim.view.loaders.ImageLoader;
import com.parim.view.swingObjects.ButtonCreator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ShopPage extends JPanel {
    private int lastX = -1, lastY = -1;
    private int coins, diamond;
    public ShopPage(){
        MainFrame.getInstance().getItems();

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }
    public void loadCombo(ItemEvent itemEvent){
        ArrayList<Item> combo = itemEvent.getAllItems();
        if (lastY == 20){
            if (lastX < 5 * 250){
                lastX += 250;
            }
            else{
                lastX = 0;
                lastY = 400;
            }
        }
        else{
            lastX += 250;
        }
        Image image1 = ImageLoader.getInstance().loadImage(combo.get(0).getName(), 110, 110);
        Image image2 = ImageLoader.getInstance().loadImage(combo.get(1).getName(), 110, 110);
        ButtonCreator button = new ButtonCreator(lastX, lastY, image1, image2,
                combo.get(0).getName(), combo.get(1).getName(),
                combo.get(0).getCost() + " + " + combo.get(1).getCost());
        button.addActionListener(e -> {
            MainFrame.getInstance().sendComboBuyItemMessage(combo.get(0).getName(), combo.get(1).getName());
        });
        if (itemEvent.getAvailableItems() == null || itemEvent.getAvailableItems().isEmpty()) button.setEnabled(false);
        else button.setEnabled(true);
        this.add(button);
    }
    public void loadShop(ItemEvent itemEvent){
        this.removeAll();

        ButtonCreator back = new ButtonCreator(1000, 650, "Back");
        back.addActionListener(e -> MainFrame.getInstance().setMenuPage());
        this.add(back);

        ArrayList<String> available = new ArrayList<>(), all = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();

        ArrayList<Item> availableItems = itemEvent.getAvailableItems(), allItems = itemEvent.getAllItems();

        for (Item item : availableItems) available.add(item.getName());
        for (Item item : allItems) {
            all.add(item.getName());
            map.put(item.getName(), item.getCost());
        }

        for (String item : all){
            int index = all.indexOf(item), x, y;
            if (index < 6){
                lastX = x = index * 250;
                lastY = y = 20;
            }
            else{
                lastX = x = (index - 6)*250;
                lastY = y = 400;
            }
            ButtonCreator button = new ButtonCreator(x, y, ImageLoader.getInstance().loadImage(item, 220, 220), item, map.get(item));
            button.addActionListener(e -> MainFrame.getInstance().sendBuyItemMessage(item));
            this.add(button);

            if (MainFrame.isOfflineGame() || !available.contains(item)) button.setEnabled(false);
            else button.setEnabled(true);
        }
    }
    public void updateUserShopData(UserShopEvent userShopEvent){
        this.coins = userShopEvent.getCoins();
        this.diamond = userShopEvent.getDiamond();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(FontLoader.notificationFont);
        g.drawString("coins: " + coins, 1350, 650);
        g.drawString("diamonds: " + diamond, 1350, 700);
    }
}
