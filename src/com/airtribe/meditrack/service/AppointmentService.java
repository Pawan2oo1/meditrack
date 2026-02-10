package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.*;
import com.airtribe.meditrack.enums.AppointmentStatus;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.util.IdGenerator;

public class AppointmentService {
    public final DataStore<Appointment> appointments = new DataStore<>();

    public void bookAppointment(int patientId, int doctorId, String date) {
        Appointment appointment = new Appointment(patientId, doctorId, date);
        appointment.setId(IdGenerator.getInstance().generateAppointmentId());
        appointments.add(appointment);
        System.out.println("✅ " + appointment);
    }

    public void viewAllAppointments() {
        var appts = appointments.getAll();
        System.out.println("\n📅 APPOINTMENTS (" + appts.size() + "):");
        appts.forEach(System.out::println);
    }

    public void cancelAppointment(int id) {
        Appointment appt = appointments.findById(id);
        if (appt != null) {
            appt.setStatus(AppointmentStatus.CANCELLED);
            System.out.println("✅ Appointment " + id + " cancelled");
        } else {
            System.out.println("❌ Appointment not found");
        }
    }

    public void generateBill(int appointmentId) {
        Appointment appt = appointments.findById(appointmentId);
        if (appt == null) {
            System.out.println("❌ Appointment not found");
            return;
        }
        double fee = 500 + (appt.getDoctorId() * 100);
        Bill bill = new Bill(appointmentId, fee);
        System.out.println("✅ " + bill);
    }
}
