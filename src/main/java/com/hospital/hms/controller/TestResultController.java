package com.hospital.hms.controller;

import com.hospital.hms.model.TestResult;
import com.hospital.hms.repository.TestResultRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test-results")
public class TestResultController extends CrudController<TestResult> {
    public TestResultController(TestResultRepository repository) { super(repository); }
}