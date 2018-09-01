package com.example.tcssi.fragments.Main;

public class Notification {
    private String day;
    private String header;
    private String details;

    public Notification(String day, String header, String details) {
        this.day = day;
        this.header = header;
        this.details = details;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
