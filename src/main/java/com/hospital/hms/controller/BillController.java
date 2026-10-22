package com.hospital.hms.controller;

import com.hospital.hms.model.Bill;
import com.hospital.hms.repository.BillRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bills")
public class BillController extends CrudController<Bill> {
    public BillController(BillRepository repository) { super(repository); }
}