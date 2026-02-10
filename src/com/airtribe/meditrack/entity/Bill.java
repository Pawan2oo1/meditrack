package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.constants.Constants;
import com.airtribe.meditrack.interfaces.Payable;

public class Bill implements Payable {
    private int appointmentId;
    private double baseAmount;
    private double taxAmount;
    private double totalAmount;

    public Bill(int appointmentId, double baseAmount) {
        this.appointmentId = appointmentId;
        this.baseAmount = baseAmount;
        this.taxAmount = baseAmount * Constants.TAX_RATE;
        this.totalAmount = baseAmount + taxAmount;
    }

    @Override
    public double calculateAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return String.format("💰 Bill[Appt=%d, Base=₹%.2f, Tax=₹%.2f, Total=₹%.2f]",
                appointmentId, baseAmount, taxAmount, totalAmount);
    }
}
