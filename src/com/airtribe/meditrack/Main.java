package com.airtribe.meditrack;

import com.airtribe.meditrack.service.*;
import com.airtribe.meditrack.util.CSVUtil;
import java.util.Scanner;

public class Main {
    private static final DoctorService doctorService = new DoctorService();
    private static final PatientService patientService = new PatientService();
    private static final AppointmentService appointmentService = new AppointmentService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🔥 Welcome to MediTrack Clinic Management!");

        if (args.length > 0 && "--loadData".equals(args[0])) {
            CSVUtil.loadAllData(doctorService, patientService, appointmentService);
        }

        showMainMenu();
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("🎯 MAIN MENU");
            System.out.println("1.  Add Doctor");
            System.out.println("2.  Add Patient");
            System.out.println("3.  Book Appointment");
            System.out.println("4.  View Appointments");
            System.out.println("5.  Cancel Appointment");
            System.out.println("6.  Search Patients");
            System.out.println("7.  Generate Bill");
            System.out.println("8. ️  List Doctors");
            System.out.println("9.  Save Data");
            System.out.println("0.  Exit");
            System.out.print("Choose option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> addDoctor();
                    case 2 -> addPatient();
                    case 3 -> bookAppointment();
                    case 4 -> appointmentService.viewAllAppointments();
                    case 5 -> cancelAppointment();
                    case 6 -> searchPatients();
                    case 7 -> generateBill();
                    case 8 -> doctorService.listAllDoctors();
                    case 9 -> CSVUtil.saveAllData(doctorService, patientService, appointmentService);
                    case 0 -> {
                        CSVUtil.saveAllData(doctorService, patientService, appointmentService);
                        System.out.println("👋 Goodbye!");
                        return;
                    }
                    default -> System.out.println("❌ Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number!");
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }
    }

    // Input methods remain the same...
    private static void addDoctor() {
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Age: ");
        String ageStr = scanner.nextLine().trim();
        System.out.print("Specialization (CARDIOLOGY/ORTHOPEDICS/...): ");
        String spec = scanner.nextLine().trim().toUpperCase();
        System.out.print("Fee: ₹");
        String feeStr = scanner.nextLine().trim();

        try {
            int age = Integer.parseInt(ageStr);
            double fee = Double.parseDouble(feeStr);
            doctorService.addDoctor(name, age, spec, fee);
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid number format!");
        }
    }

    private static void addPatient() {
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Age: ");
        String ageStr = scanner.nextLine().trim();
        System.out.print("Phone (10 digits): ");
        String phone = scanner.nextLine().trim();

        try {
            int age = Integer.parseInt(ageStr);
            patientService.addPatient(name, age, phone);
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid age format!");
        }
    }

    private static void bookAppointment() {
        System.out.print("Patient ID: ");
        int patientId = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Doctor ID: ");
        int doctorId = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Date (yyyy-MM-dd): ");
        String date = scanner.nextLine().trim();
        appointmentService.bookAppointment(patientId, doctorId, date);
    }

    private static void cancelAppointment() {
        System.out.print("Appointment ID: ");
        int id = Integer.parseInt(scanner.nextLine().trim());
        appointmentService.cancelAppointment(id);
    }

    private static void searchPatients() {
        System.out.print("Search term: ");
        String value = scanner.nextLine().trim();
        patientService.searchPatients(2, value);
    }

    private static void generateBill() {
        System.out.print("Appointment ID: ");
        int appId = Integer.parseInt(scanner.nextLine().trim());
        appointmentService.generateBill(appId);
    }
}
