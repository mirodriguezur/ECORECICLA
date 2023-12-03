package com.example.ecorecicla.models;

public class Paper {
    private int numberOfLeaves;
    private int price;
    private String month;
    private int points;

    public Paper(int numberOfLeaves, int price, String month, int points) {
        this.numberOfLeaves = numberOfLeaves;
        this.price = price;
        this.month = month;
        this.points = points;
    }

    public int getNumberOfLeaves() {
        return numberOfLeaves;
    }

    public void setNumberOfLeaves(int numberOfLeaves) {
        this.numberOfLeaves = numberOfLeaves;
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
