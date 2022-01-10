package com.example.cookhub.models;

public class MainMenuItem {
    private String itemName;
    private int itemSrcId;

    public MainMenuItem(String itemName, int itemSrcId) {
        this.itemName = itemName;
        this.itemSrcId = itemSrcId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemSrcId() {
        return itemSrcId;
    }

    public void setItemSrcId(int itemSrcId) {
        this.itemSrcId = itemSrcId;
    }
}
