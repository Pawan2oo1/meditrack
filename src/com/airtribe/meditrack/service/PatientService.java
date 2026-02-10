package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.util.IdGenerator;

public class PatientService {
    public final DataStore<Patient> patients = new DataStore<>();

    public void addPatient(String name, int age, String phone) {
        Patient patient = new Patient(name, age, phone);
        patient.setId(IdGenerator.getInstance().generatePatientId());
        patients.add(patient);
        System.out.println("✅ " + patient);
    }

    public void searchPatients(int type, String value) {
        System.out.println("🔍 Searching patients...");
        var results = patients.search(value);
        if (results.isEmpty()) {
            System.out.println("❌ No matches found");
        } else {
            results.forEach(System.out::println);
        }
    }
}
