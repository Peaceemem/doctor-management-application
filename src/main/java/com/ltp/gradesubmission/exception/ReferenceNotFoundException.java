package com.ltp.gradesubmission.exception;

public class ReferenceNotFoundException extends RuntimeException { 

    public ReferenceNotFoundException(Long doctorId) {
        super("The reference with doctor id: '" + doctorId + "' does not exist in our records");
    }
    
}