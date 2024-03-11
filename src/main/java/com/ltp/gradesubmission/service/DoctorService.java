package com.ltp.gradesubmission.service;

import java.util.List;
import com.ltp.gradesubmission.entity.Doctor;

public interface DoctorService {
    Doctor getDoctor(Long id);
    Doctor saveDoctor(Doctor doctor);
    Doctor updateDoctor(Doctor doctor, Long id);
    void deleteDoctor(Long id);
    List<Doctor> getDoctors();
}