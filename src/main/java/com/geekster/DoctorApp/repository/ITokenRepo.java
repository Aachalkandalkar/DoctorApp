package com.geekster.DoctorApp.repository;

import com.geekster.DoctorApp.models.AuthenticationToken;
import com.geekster.DoctorApp.models.Patient;
import org.hibernate.sql.exec.spi.JdbcCallParameterExtractor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findByPatient(Patient patient);

    AuthenticationToken findFirstByToken(String token);
}
