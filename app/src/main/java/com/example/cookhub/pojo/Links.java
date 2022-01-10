package com.example.cookhub.pojo;

public class Links {

    private Self self;
    private Next next;

    public Links() {
    }

    public Links(Self self, Next next) {
        this.self = self;
        this.next = next;
    }

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public Next getNext() {
        return next;
    }

    public void setNext(Next next) {
        this.next = next;
    }
}
