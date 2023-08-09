package com.parim.event.shop;

import com.parim.event.FormEvent;

public class BuyItemEvent implements FormEvent {
    private String item;
    public BuyItemEvent(){}

    public BuyItemEvent(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
