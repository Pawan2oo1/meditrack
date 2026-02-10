package com.airtribe.meditrack.util;

public class Validator {
    public static boolean isValidName(String name) {
        return name != null && name.trim().length() >= 2 && name.length() <= 50;
    }

    public static boolean isValidAge(int age) {
        return age >= 0 && age <= 120;
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }

    public static boolean isValidFee(double fee) {
        return fee > 0 && fee <= 100000;
    }
}
