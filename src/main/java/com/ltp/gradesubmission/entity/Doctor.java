package com.ltp.gradesubmission.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Phone number cannot be blank")
    @NonNull
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotBlank(message = "Email cannot be blank")
    @NonNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank(message = "Address cannot be blank")
    @NonNull
    @Column(name = "address", nullable = false)
    private String address;

    @Past(message = "The birth date must be in the past")
    @NonNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @NotBlank(message = "License number cannot be blank")
    @NonNull
    @Column(name = "license_number", nullable = false)
    private String licenseNumber;

    @NotBlank(message = "Issuing authority number cannot be blank")
    @NonNull
    @Column(name = "issuing_authority", nullable = false)
    private String issuingAuthority;

    @NotBlank(message = "Gender cannot be blank")
    @NonNull
    @Column(name = "gender", nullable = false)
    private String gender; 

    @NotBlank(message = "Medical Certificate URL cannot be blank")
    @NonNull
    @Column(name = "medical_certificate_url", nullable = false)
    private String medicalCertificateUrl;
    
    @JsonIgnore
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<References> professionalReferences;


}
