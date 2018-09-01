package com.example.tcssi.fragments;

public class item {

    int background;
    String applicName;
    int desc;

    public item() {
    }

    public item(int background, String applicName, int desc) {
        this.background = background;
        this.applicName = applicName;
        this.desc = desc;
    }

    public int getBackground() {
        return background;
    }

    public String getApplicName() {
        return applicName;
    }

    public int getDesc() {
        return desc;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public void setApplicName(String applicName) {
        this.applicName = applicName;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }
}
