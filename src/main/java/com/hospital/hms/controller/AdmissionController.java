package com.hospital.hms.controller;

import com.hospital.hms.model.Admission;
import com.hospital.hms.repository.AdmissionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/admissions")
public class AdmissionController extends CrudController<Admission> {

    private final JdbcTemplate jdbc;

    public AdmissionController(AdmissionRepository repository, JdbcTemplate jdbc) {
        super(repository);
        this.jdbc = jdbc;
    }

    @PostMapping("/{id}/discharge")
    public ResponseEntity<Map<String, String>> discharge(@PathVariable Integer id) {
        int rows = jdbc.update(
            "UPDATE admission SET discharge_date = CURDATE(), status = 'Discharged' " +
            "WHERE admission_id = ? AND status = 'Admitted'", id);
        if (rows == 0) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("message", "Not found or already discharged"));
        }
        return ResponseEntity.ok(Map.of("message", "Patient discharged"));
    }
}
