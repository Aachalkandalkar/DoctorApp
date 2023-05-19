package com.geekster.DoctorApp.service;

import com.geekster.DoctorApp.dto.SignInInput;
import com.geekster.DoctorApp.dto.SignInOutput;
import com.geekster.DoctorApp.dto.SignUpInput;
import com.geekster.DoctorApp.dto.SignUpOutput;
import com.geekster.DoctorApp.models.AppointmentKey;
import com.geekster.DoctorApp.models.AuthenticationToken;
import com.geekster.DoctorApp.models.Doctor;
import com.geekster.DoctorApp.models.Patient;
import com.geekster.DoctorApp.repository.IPatientRepo;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    IPatientRepo iPatientRepo;

    @Autowired
    DoctorService doctorService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    AuthenticationService tokenService;



    public SignUpOutput signUp(SignUpInput signUpDto) {

     //check if user exist or not based on email
        Patient patient  = iPatientRepo.findFirstByPatientEmail(signUpDto.getUserEmail());

        if(patient != null){
            throw new IllegalStateException("Patient already exist!!!.....sign in instead");

        }

        //encryption

        String encryptedPassword = null;
        try {
            encryptedPassword = encryptedPassword(signUpDto.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


        //save the user

        patient = new Patient(signUpDto.getUserFirstName(),signUpDto.getUserLastName(), signUpDto.getUserEmail(),
                encryptedPassword, signUpDto.getUserContact());

                iPatientRepo.save(patient);

        //token creation and saving

        AuthenticationToken token = new AuthenticationToken(patient);
        tokenService.saveToken(token);

        return new SignUpOutput("Patient registered", "Patient created succesfully");
    }

    private String encryptedPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public SignInOutput signIn(SignInInput signInDto) {

        //get email
        Patient patient  = iPatientRepo.findFirstByPatientEmail(signInDto.getPatientEmail());

        if(patient == null){
            throw new IllegalStateException("User invalid!!!.....sign up instead");

        }

        //encrypt the password

        String encryptedPassword = null;

        try{
            encryptedPassword = encryptedPassword(signInDto.getPatientPassword());
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        //match it with database encrypted password

        boolean isPasswordValid = encryptedPassword.equals(patient.getPatientPassword());

        if(!isPasswordValid){
            throw new IllegalStateException("User invalid!!!...sign up instead");
        }

        //figure out the token


        AuthenticationToken  authToken = tokenService.getToken(patient);

        // set up output response

        return new SignInOutput("Authentication Successfull!!!", authToken.getToken());
    }
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    public void cancelAppointment(AppointmentKey key) {

        appointmentService.cancelAppointment(key);

    }
}
