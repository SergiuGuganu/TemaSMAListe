package com.example.myapplication;

public class ListModel {
    private String up;
    private String low;

    public ListModel(String up, String low) {
        this.up = up;
        this.low = low;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }
}
