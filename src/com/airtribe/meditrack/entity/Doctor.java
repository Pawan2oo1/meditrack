package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.enums.Specialization;
import com.airtribe.meditrack.util.Validator;

public class Doctor extends Person {
    private Specialization specialization;
    private double consultationFee;

    public Doctor(String name, int age, String specializationStr, double fee) {
        super(name, age);
        try {
            this.specialization = Specialization.valueOf(specializationStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            this.specialization = Specialization.GENERAL;
        }
        if (Validator.isValidFee(fee)) {
            this.consultationFee = fee;
        } else {
            this.consultationFee = 500.0;
        }
    }

    public Specialization getSpecialization() { return specialization; }
    public double getConsultationFee() { return consultationFee; }

    @Override
    public boolean matches(String criteria) {
        return getName().toLowerCase().contains(criteria.toLowerCase()) ||
                specialization.name().toLowerCase().contains(criteria.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("👨‍⚕️ Doctor[id=%d, %s, %s, ₹%.2f]",
                getId(), getName(), specialization, consultationFee);
    }
}
