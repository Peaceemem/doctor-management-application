package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.ltp.gradesubmission.entity.Doctor;
import com.ltp.gradesubmission.exception.DoctorNotFoundException;
import com.ltp.gradesubmission.repository.DoctorRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@SuppressWarnings("null")
public class DoctorServiceImpl implements DoctorService {


    DoctorRepository doctorRepository;

    @Override
    public Doctor getDoctor(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return unwrapDoctor(doctor, id);
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor, Long id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        Doctor repoDoctor = unwrapDoctor(optionalDoctor, id);
        repoDoctor.setName(doctor.getName());
        repoDoctor.setPhoneNumber(doctor.getPhoneNumber());
        repoDoctor.setAddress(doctor.getAddress());
        repoDoctor.setEmail(doctor.getEmail());
        repoDoctor.setBirthDate(doctor.getBirthDate());
        repoDoctor.setGender(doctor.getGender());
        repoDoctor.setIssuingAuthority(doctor.getIssuingAuthority());
        repoDoctor.setLicenseNumber(doctor.getLicenseNumber());
        repoDoctor.setMedicalCertificateUrl(doctor.getMedicalCertificateUrl());

        return doctorRepository.save(repoDoctor);
    }

    @Override
    public void deleteDoctor(Long id) {      
        doctorRepository.deleteById(id);  
    }

    @Override
    public List<Doctor> getDoctors() {
        return (List<Doctor>)doctorRepository.findAll();
    }

    static Doctor unwrapDoctor(Optional<Doctor> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new DoctorNotFoundException(id);
    }

}