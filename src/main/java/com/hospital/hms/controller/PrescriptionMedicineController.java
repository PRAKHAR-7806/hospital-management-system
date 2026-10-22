package com.hospital.hms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions/{prescriptionId}/medicines")
public class PrescriptionMedicineController {

    record ItemRequest(Integer medicineId, String dosage,
                       String frequency, Integer durationDays) { }

    private final JdbcTemplate jdbc;

    public PrescriptionMedicineController(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    @GetMapping
    public List<Map<String, Object>> list(@PathVariable Integer prescriptionId) {
        return jdbc.queryForList(
            "SELECT pm.medicine_id, m.medicine_name, m.unit_price, " +
            "pm.dosage, pm.frequency, pm.duration_days " +
            "FROM prescription_medicine pm " +
            "JOIN medicine m ON pm.medicine_id = m.medicine_id " +
            "WHERE pm.prescription_id = ?", prescriptionId);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> add(
            @PathVariable Integer prescriptionId, @RequestBody ItemRequest r) {
        jdbc.update("INSERT INTO prescription_medicine " +
            "(prescription_id, medicine_id, dosage, frequency, duration_days) " +
            "VALUES (?, ?, ?, ?, ?)",
            prescriptionId, r.medicineId(), r.dosage(), r.frequency(), r.durationDays());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "Medicine added"));
    }

    @DeleteMapping("/{medicineId}")
    public ResponseEntity<Void> remove(@PathVariable Integer prescriptionId,
                                       @PathVariable Integer medicineId) {
        jdbc.update("DELETE FROM prescription_medicine " +
            "WHERE prescription_id = ? AND medicine_id = ?",
            prescriptionId, medicineId);
        return ResponseEntity.noContent().build();
    }
}