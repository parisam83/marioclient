package com.parim.event.shop;

import com.parim.event.FormEvent;

public class ComboBuyItemEvent implements FormEvent {
    private String item1, item2;
    public ComboBuyItemEvent(){}

    public ComboBuyItemEvent(String item1, String item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }
}
