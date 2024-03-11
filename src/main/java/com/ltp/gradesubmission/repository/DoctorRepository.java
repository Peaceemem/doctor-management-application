package com.ltp.gradesubmission.repository;

import org.springframework.data.repository.CrudRepository;

import com.ltp.gradesubmission.entity.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}