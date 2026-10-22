package com.hospital.hms.controller;

import com.hospital.hms.model.Department;
import com.hospital.hms.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController extends CrudController<Department> {
    public DepartmentController(DepartmentRepository repository) { super(repository); }
}