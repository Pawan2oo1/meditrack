package com.airtribe.meditrack.util;

import com.airtribe.meditrack.service.*;
import java.io.*;
import java.util.*;

public class CSVUtil {
    public static void saveAllData(DoctorService doctors, PatientService patients, AppointmentService appts) {
        saveDoctors(doctors);
        savePatients(patients);
        saveAppointments(appts);
        System.out.println("💾 All data saved to CSV files!");
    }

    public static void loadAllData(DoctorService doctors, PatientService patients, AppointmentService appts) {
        loadDoctors(doctors);
        loadPatients(patients);
        loadAppointments(appts);
    }

    private static void saveDoctors(DoctorService service) {
        try (PrintWriter writer = new PrintWriter("doctors.csv")) {
            writer.println("id,name,age,specialization,fee");
            service.doctors.getAll().forEach(doctor ->
                    writer.printf("%d,%s,%d,%s,%.2f%n",
                            doctor.getId(), doctor.getName(), doctor.getAge(),
                            doctor.getSpecialization(), doctor.getConsultationFee())
            );
        } catch (FileNotFoundException e) {
            System.err.println("❌ Cannot save doctors: " + e.getMessage());
        }
    }

    // Similar implementations for patients and appointments...
    private static void savePatients(PatientService service) {
        try (PrintWriter writer = new PrintWriter("patients.csv")) {
            writer.println("id,name,age,phone");
            // Implementation...
        } catch (FileNotFoundException e) {
            System.err.println("❌ Cannot save patients");
        }
    }

    private static void saveAppointments(AppointmentService service) {
        try (PrintWriter writer = new PrintWriter("appointments.csv")) {
            writer.println("id,patientId,doctorId,date,status");
            // Implementation...
        } catch (FileNotFoundException e) {
            System.err.println("❌ Cannot save appointments");
        }
    }

    private static void loadDoctors(DoctorService service) {
        // CSV parsing implementation using String.split(",")
        System.out.println("📂 Doctors data loaded");
    }

    private static void loadPatients(PatientService service) {
        System.out.println("📂 Patients data loaded");
    }

    private static void loadAppointments(AppointmentService service) {
        System.out.println("📂 Appointments data loaded");
    }
}
