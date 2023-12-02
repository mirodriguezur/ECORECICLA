package com.example.ecorecicla.models;

public class DataValidator {

    public boolean validateFormatEmail(String email) {
        return email != null && !email.isEmpty() && isValidEmailFormat(email);
    }

    public boolean validateFormatCellNumber(String number) {
        return number != null && !number.isEmpty() && isValidCellNumberFormat(number);
    }

    public boolean validateFormatPassword(Integer password) {
        return isValidPasswordFormat(String.valueOf(password));
    }

    private boolean isValidEmailFormat(String email) {
        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');
        return atIndex > 0 && dotIndex > atIndex && dotIndex < email.length() - 1;
    }

    private boolean isValidPasswordFormat(String password) {
        return password.length() == 5;
    }

    private boolean isValidCellNumberFormat(String number) {
        String digitsOnly = number.replaceAll("[^0-9]", "");
        return digitsOnly.length() == 10;
    }
}
