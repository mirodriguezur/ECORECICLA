package com.example.ecorecicla;

import androidx.lifecycle.ViewModel;
import com.example.ecorecicla.models.User;

public class UserSingleton {

    private static UserSingleton user;
    public String firstName;
    public String lastName;
    public String email;
    public String cellNumber;
    public String city;

    private UserSingleton () {
        firstName = "";
        lastName = "";
        email = "";
        cellNumber = "";
        city = "";
    }

    public static UserSingleton sharedInstance() {
        if (user == null) {
            user = new UserSingleton();
        }
        return user;
    }

    public static UserSingleton getUser() {
        return user;
    }

    public static void setUser(UserSingleton user) {
        UserSingleton.user = user;
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

    public static void deinitialize() {
        user = null;
    }
}
