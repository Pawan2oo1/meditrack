package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.enums.AppointmentStatus;
import com.airtribe.meditrack.interfaces.Payable;

public class Appointment implements Payable {
    private int id;
    private final int patientId;
    private final int doctorId;
    private final String date;
    private AppointmentStatus status;

    public Appointment(int patientId, int doctorId, String date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.status = AppointmentStatus.CONFIRMED;
    }

    // ✅ ALL PUBLIC getters/setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public String getDate() { return date; }
    public AppointmentStatus getStatus() { return status; }
    public void setStatus(AppointmentStatus status) { this.status = status; }

    @Override
    public double calculateAmount() {
        return 0; // Service calculates real amount
    }

    @Override
    public String toString() {
        return String.format("📅 Appt[id=%d, P%d→D%d, %s, %s]",
                id, patientId, doctorId, date, status);
    }
}
