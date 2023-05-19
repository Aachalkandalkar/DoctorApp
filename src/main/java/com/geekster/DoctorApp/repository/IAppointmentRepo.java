package com.geekster.DoctorApp.repository;


import com.geekster.DoctorApp.models.Appointment;
import com.geekster.DoctorApp.models.AppointmentKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepo extends JpaRepository<Appointment, AppointmentKey> {

    public String findByIdAppId(Long id);

    public Appointment save(Appointment appointment);
}
