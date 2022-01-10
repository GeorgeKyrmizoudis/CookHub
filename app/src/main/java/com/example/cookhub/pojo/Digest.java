package com.example.cookhub.pojo;

import java.util.ArrayList;

public class Digest {
    public String label;
    public String tag;
    public String schemaOrgTag;
    public float total;
    public boolean hasRDI;
    public float daily;
    public String unit;
    public ArrayList<Sub> sub;

    public Digest() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSchemaOrgTag() {
        return schemaOrgTag;
    }

    public void setSchemaOrgTag(String schemaOrgTag) {
        this.schemaOrgTag = schemaOrgTag;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isHasRDI() {
        return hasRDI;
    }

    public void setHasRDI(boolean hasRDI) {
        this.hasRDI = hasRDI;
    }

    public float getDaily() {
        return daily;
    }

    public void setDaily(int daily) {
        this.daily = daily;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ArrayList<Sub> getSub() {
        return sub;
    }

    public void setSub(ArrayList<Sub> sub) {
        this.sub = sub;
    }
}
