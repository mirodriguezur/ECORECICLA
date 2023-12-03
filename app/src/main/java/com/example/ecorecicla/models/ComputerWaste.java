package com.example.ecorecicla.models;

public class ComputerWaste {
private int elements;
private int price;
private String month;
private int points;

    public ComputerWaste(int elements, int price, String month, int points) {
        this.elements = elements;
        this.price = price;
        this.month = month;
        this.points = points;
    }

    public int getElements() {
        return elements;
    }

    public void setElements(int elements) {
        this.elements = elements;
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
