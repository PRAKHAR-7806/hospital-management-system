package com.hospital.hms.controller;

import com.hospital.hms.model.Prescription;
import com.hospital.hms.repository.PrescriptionRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController extends CrudController<Prescription> {
    public PrescriptionController(PrescriptionRepository repository) { super(repository); }
}