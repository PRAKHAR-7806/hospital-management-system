package com.hospital.hms.controller;

import com.hospital.hms.model.Doctor;
import com.hospital.hms.repository.DoctorRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController extends CrudController<Doctor> {
    public DoctorController(DoctorRepository repository) { super(repository); }
}