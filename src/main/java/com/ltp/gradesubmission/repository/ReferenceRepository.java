package com.ltp.gradesubmission.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ltp.gradesubmission.entity.References;


public interface ReferenceRepository extends CrudRepository<References, Long> {
    Optional<References> findByDoctorId(Long doctorId);
    void deleteByDoctorId(Long doctorId);
}