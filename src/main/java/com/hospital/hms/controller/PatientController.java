package com.hospital.hms.controller;

import com.hospital.hms.model.Patient;
import com.hospital.hms.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController extends CrudController<Patient> {
    public PatientController(PatientRepository repository) { super(repository); }
}