package com.ltp.gradesubmission.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.gradesubmission.entity.References;
import com.ltp.gradesubmission.service.ReferenceService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/references")
public class ReferenceController {
    
    ReferenceService referenceService;

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<References> getReference(@PathVariable Long doctorId) {
        return new ResponseEntity<>(referenceService.getReferences(doctorId), HttpStatus.OK);
    }

    @PostMapping("/doctor/{doctorId}")
    public ResponseEntity<References> saveReference(@Valid @RequestBody References reference, @PathVariable Long doctorId) {
        return new ResponseEntity<>(referenceService.saveReference(reference, doctorId), HttpStatus.CREATED);
    }

    @PutMapping("/doctor/{doctorId}")
    public ResponseEntity<References> updateReference(@Valid @RequestBody References reference, @PathVariable Long doctorId) {
        return new ResponseEntity<>(referenceService.updateReference(reference.getName(), reference.getAffiliation(), doctorId), HttpStatus.OK);
    }

    @DeleteMapping("/doctor/{doctorId}")
    public ResponseEntity<HttpStatus> deleteReference(@PathVariable Long doctorId) {
        referenceService.deleteReference(doctorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<References>> getReferences() {
        return new ResponseEntity<>(referenceService.getAllReferences(), HttpStatus.OK);
    }

}
