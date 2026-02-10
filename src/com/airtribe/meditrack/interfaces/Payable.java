package com.airtribe.meditrack.interfaces;

public interface Payable {
    double calculateAmount();

    default String generateReceipt() {
        return "Receipt generated for ₹" + calculateAmount();
    }
}
