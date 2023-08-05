package com.parim.event;

import com.parim.model.Item;

import java.util.ArrayList;

public class ItemEvent implements FormEvent {
    private ArrayList<Item> availableItems, allItems;
    public ItemEvent(){}

    public ItemEvent(ArrayList<Item> availableItems, ArrayList<Item> allItems) {
        this.availableItems = availableItems;
        this.allItems = allItems;
    }

    public ArrayList<Item> getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(ArrayList<Item> availableItems) {
        this.availableItems = availableItems;
    }

    public ArrayList<Item> getAllItems() {
        return allItems;
    }

    public void setAllItems(ArrayList<Item> allItems) {
        this.allItems = allItems;
    }
}
