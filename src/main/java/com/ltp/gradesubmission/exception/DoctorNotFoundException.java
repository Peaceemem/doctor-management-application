package com.ltp.gradesubmission.exception;

public class DoctorNotFoundException extends RuntimeException { 

    public DoctorNotFoundException(Long id) {
        super("The doctor id '" + id + "' does not exist in our records");
    }
    
}