package com.example.cookhub.pojo;

public class Next {
    private String href;
    private String title;

    public Next() {
    }

    public Next(String title) {
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
