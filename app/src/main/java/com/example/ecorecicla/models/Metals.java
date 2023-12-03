package com.example.ecorecicla.models;

public class Metals {
    private int kilograms;
    private int price;
    private String month;
    private int points;

    public Metals(int kilograms, int price, String month, int points) {
        this.kilograms = kilograms;
        this.price = price;
        this.month = month;
        this.points = points;
    }
    public int getKilograms() {
        return kilograms;
    }

    public void setKilograms(int kilograms) {
        this.kilograms = kilograms;
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
