package com.geekster.DoctorApp.service;

import com.geekster.DoctorApp.models.AuthenticationToken;
import com.geekster.DoctorApp.models.Patient;

public interface IAuthService {

    void saveToken(AuthenticationToken token);
    AuthenticationToken getToken(Patient patient);
    boolean authenticate(String userEmail, String token);


}