package com.ltp.gradesubmission.service;

import java.util.List;

import com.ltp.gradesubmission.entity.Doctor;
import com.ltp.gradesubmission.entity.References;
import com.ltp.gradesubmission.exception.ReferenceNotFoundException;
import com.ltp.gradesubmission.repository.ReferenceRepository;
import com.ltp.gradesubmission.repository.DoctorRepository;
import java.util.Optional;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReferenceServiceImpl implements ReferenceService {
    
    ReferenceRepository referenceRepository;
    DoctorRepository doctorRepository;
    
    @Override
    public References getReferences(Long doctorId) {
        Optional<References> reference = referenceRepository.findByDoctorId(doctorId);
        return unwrapReference(reference, doctorId);
    }

    @SuppressWarnings("null")
    @Override
    public References saveReference(References reference, Long doctorId) {
        Doctor doctor = DoctorServiceImpl.unwrapDoctor(doctorRepository.findById(doctorId), doctorId);
        reference.setDoctor(doctor);
        doctor.getProfessionalReferences().add(reference);
        doctorRepository.save(doctor);
        return referenceRepository.save(reference);
    }

    @Override
    public References updateReference(String name, String affiliation, Long doctorId) {
        Optional<References> reference = referenceRepository.findByDoctorId(doctorId);
        References unwrappedReference = unwrapReference(reference, doctorId);
        unwrappedReference.setName(name);
        unwrappedReference.setAffiliation(affiliation);
        return referenceRepository.save(unwrappedReference);
    }

    @Override
    public void deleteReference(Long doctorId) {
        referenceRepository.deleteByDoctorId(doctorId);
    }

    @Override
    public List<References> getAllReferences() {
        return (List<References>) referenceRepository.findAll();
    }

    static References unwrapReference(Optional<References> entity, Long doctorId) {
        if (entity.isPresent()) return entity.get();
        else throw new ReferenceNotFoundException(doctorId);
    }

}
