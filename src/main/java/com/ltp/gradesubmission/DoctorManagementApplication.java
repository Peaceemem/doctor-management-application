package com.ltp.gradesubmission;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ltp.gradesubmission.repository.ReferenceRepository;
import com.ltp.gradesubmission.entity.Doctor;
import com.ltp.gradesubmission.repository.DoctorRepository;

@SpringBootApplication
public class DoctorManagementApplication implements CommandLineRunner {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	ReferenceRepository referenceRepository;

	public static void main(String[] args) {
		SpringApplication.run(DoctorManagementApplication.class, args);
	}

	@SuppressWarnings("null")
    @Override
	public void run(String... args) throws Exception {
		Doctor[] doctors = new Doctor[] {
            new Doctor("Harry Potter", "123456789", "peaceofficial57@gmail.com", "60 Tal Wotal Street, Enugu.", LocalDate.parse(("1980-07-31")), "987654321", "Nigerian Association of Doctors", "FEMALE", "https://i.postimg.cc/m2mK7Q0c/deji-akinyele-ARm28szw-P0o-unsplash.jpg"),
            new Doctor("Jane Smith", "08137489374", "jane.smith@medschool.edu", "50 Sal Wotal Street, Enugu.", LocalDate.parse(("1980-07-31")), "987654321", "Nigerian Association of Doctors", "MALE", "https://i.postimg.cc/m2mK7Q0c/deji-akinyele-ARm28szw-P0o-unsplash.jpg"),
            new Doctor("John Paul", "09374637489", "john.doe@medschool.edu", "40 Tal Gotal Street, Enugu.", LocalDate.parse(("1980-07-31")), "987654321", "Nigerian Association of Doctors", "MALE", "https://i.postimg.cc/m2mK7Q0c/deji-akinyele-ARm28szw-P0o-unsplash.jpg"),
            new Doctor("Harry Jane", "637291748090", "peaceofficial57@gmail.com", "30 Lal Wotal Street, Enugu.", LocalDate.parse(("1980-07-31")), "987654321", "Nigerian Association of Doctors", "MALE", "https://i.postimg.cc/m2mK7Q0c/deji-akinyele-ARm28szw-P0o-unsplash.jpg"),
            new Doctor("Harry Smith", "16354839203", "peaceofficial57@gmail.com", "20 Tal Yotal Street, Enugu.", LocalDate.parse(("1980-07-31")), "987654321", "Nigerian Association of Doctors", "MALE", "https://i.postimg.cc/m2mK7Q0c/deji-akinyele-ARm28szw-P0o-unsplash.jpg")
        };
		
		for (int i = 0; i < doctors.length; i++) {
			doctorRepository.save(doctors[i]);
		}
	}
}
