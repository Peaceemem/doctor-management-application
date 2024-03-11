package com.ltp.gradesubmission.service;

import java.util.List;

import com.ltp.gradesubmission.entity.References;

public interface ReferenceService {
    References getReferences(Long doctorId);
    References saveReference(References reference, Long doctorId);
    References updateReference(String name, String affiliation, Long doctorId);
    void deleteReference(Long doctorId);
    List<References> getAllReferences();
}
