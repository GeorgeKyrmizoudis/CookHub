package com.example.cookhub.pojo;

public class Self {
    private String href;
    private String title;

    public Self() {
    }

    public Self(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}