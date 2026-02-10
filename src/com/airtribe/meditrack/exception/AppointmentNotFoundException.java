package com.airtribe.meditrack.exception;

public class AppointmentNotFoundException extends Exception {
    public AppointmentNotFoundException(int id) {
        super("Appointment ID " + id + " not found");
    }
}
