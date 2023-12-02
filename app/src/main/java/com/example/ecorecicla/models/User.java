package com.example.ecorecicla.models;

public class User {

    public String firstName;
    public String lastName;
    public String email;
    public String cellNumber;
    public String city;
    public Integer password;

    public User(String firstName, String lastName, String email, String cellNumber, String city, Integer password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cellNumber = cellNumber;
        this.city = city;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }
}
