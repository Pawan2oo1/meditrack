package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.util.Validator;

public class Patient extends Person {
    private String phone;

    public Patient(String name, int age, String phone) {
        super(name, age);
        if (Validator.isValidPhone(phone)) {
            this.phone = phone;
        } else {
            this.phone = "0000000000";
        }
    }

    public String getPhone() { return phone; }

    @Override
    public boolean matches(String criteria) {
        return getName().toLowerCase().contains(criteria.toLowerCase()) ||
                Integer.toString(getAge()).equals(criteria) ||
                getPhone().contains(criteria);
    }

    @Override
    public String toString() {
        return String.format("👤 Patient[id=%d, %s, age=%d, %s]",
                getId(), getName(), getAge(), phone);
    }
}
