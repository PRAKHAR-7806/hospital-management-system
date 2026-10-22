package com.hospital.hms.controller;

import com.hospital.hms.model.Appointment;
import com.hospital.hms.repository.AppointmentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController extends CrudController<Appointment> {
    public AppointmentController(AppointmentRepository repository) { super(repository); }
}
