package com.example.cookhub.pojo;

import java.util.ArrayList;

public class JsonResponse {

    private int from;
    private int to;
    private int count;
    private Links _links;
    private ArrayList<Hit> hits;

    public JsonResponse() {
    }

    public JsonResponse(int from, int to, int count, Links _links, ArrayList<Hit> hits) {
        this.from = from;
        this.to = to;
        this.count = count;
        this._links = _links;
        this.hits = hits;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    public ArrayList<Hit> getHits() {
        return hits;
    }

    public void setHits(ArrayList<Hit> hits) {
        this.hits = hits;
    }
}
