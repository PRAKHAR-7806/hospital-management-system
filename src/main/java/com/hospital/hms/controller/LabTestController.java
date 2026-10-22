package com.hospital.hms.controller;

import com.hospital.hms.model.LabTest;
import com.hospital.hms.repository.LabTestRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lab-tests")
public class LabTestController extends CrudController<LabTest> {
    public LabTestController(LabTestRepository repository) { super(repository); }
}