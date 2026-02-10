package com.airtribe.meditrack.util;

public class IdGenerator {
    private static volatile IdGenerator instance;
    private int doctorCounter = 1;
    private int patientCounter = 1;
    private int appointmentCounter = 1;

    // Static block - Advanced OOP
    static {
        System.out.println("🔧 IdGenerator static block executed");
    }

    private IdGenerator() {
        System.out.println("🔧 IdGenerator instance created");
    }

    // Thread-safe lazy singleton
    public static IdGenerator getInstance() {
        if (instance == null) {
            synchronized (IdGenerator.class) {
                if (instance == null) {
                    instance = new IdGenerator();
                }
            }
        }
        return instance;
    }

    public synchronized int generateDoctorId() { return doctorCounter++; }
    public synchronized int generatePatientId() { return patientCounter++; }
    public synchronized int generateAppointmentId() { return appointmentCounter++; }
}
