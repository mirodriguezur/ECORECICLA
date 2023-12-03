package com.example.ecorecicla.models;

public class Plastic {
    private int volume;
    private int price;
    private String month;
    private int points;

    public Plastic(int volume, int price, String month, int points) {
        this.volume = volume;
        this.price = price;
        this.month = month;
        this.points = points;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
