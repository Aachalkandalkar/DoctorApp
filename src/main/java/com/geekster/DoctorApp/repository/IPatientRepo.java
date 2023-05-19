package com.geekster.DoctorApp.repository;

import com.geekster.DoctorApp.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepo extends JpaRepository<Patient,Long> {
    Patient findFirstByPatientEmail(String userEmail);

}
