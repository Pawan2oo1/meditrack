package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.util.IdGenerator;

public class DoctorService {
    public final DataStore<Doctor> doctors = new DataStore<>();

    public void addDoctor(String name, int age, String specialization, double fee) {
        Doctor doctor = new Doctor(name, age, specialization, fee);
        doctor.setId(IdGenerator.getInstance().generateDoctorId());
        doctors.add(doctor);
        System.out.println("✅ " + doctor);
    }

    public void listAllDoctors() {
        var doctorList = doctors.getAll();
        System.out.println("\n👨‍⚕️ DOCTORS (" + doctorList.size() + "):");
        if (doctorList.isEmpty()) {
            System.out.println("No doctors found");
            return;
        }
        doctorList.forEach(System.out::println);

        double avgFee = doctorList.stream()
                .mapToDouble(Doctor::getConsultationFee)
                .average().orElse(0);
        System.out.printf("\n📈 Analytics: Avg Fee=₹%.2f%n", avgFee);
    }
}
