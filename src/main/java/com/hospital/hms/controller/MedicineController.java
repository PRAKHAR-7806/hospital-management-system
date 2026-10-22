package com.hospital.hms.controller;

import com.hospital.hms.model.Medicine;
import com.hospital.hms.repository.MedicineRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController extends CrudController<Medicine> {
    public MedicineController(MedicineRepository repository) { super(repository); }
}
