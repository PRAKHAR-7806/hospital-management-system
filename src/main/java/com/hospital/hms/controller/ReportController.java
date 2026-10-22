package com.hospital.hms.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final JdbcTemplate jdbc;
    public ReportController(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    @GetMapping("/dashboard")
    public Map<String, Object> dashboard() {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("totalPatients",
            jdbc.queryForObject("SELECT COUNT(*) FROM patient", Integer.class));
        m.put("totalDoctors",
            jdbc.queryForObject("SELECT COUNT(*) FROM doctor", Integer.class));
        m.put("scheduledAppointments",
            jdbc.queryForObject("SELECT COUNT(*) FROM appointment WHERE status='Scheduled'",
                Integer.class));
        m.put("currentAdmissions",
            jdbc.queryForObject("SELECT COUNT(*) FROM admission WHERE status='Admitted'",
                Integer.class));
        m.put("lowStockMedicines",
            jdbc.queryForObject("SELECT COUNT(*) FROM medicine WHERE stock_quantity < 200",
                Integer.class));
        m.put("pendingAmount",
            jdbc.queryForObject("SELECT COALESCE(SUM(total_amount),0) FROM bill " +
                "WHERE payment_status <> 'Paid'", BigDecimal.class));
        return m;
    }

    @GetMapping("/appointments")
    public List<Map<String, Object>> appointments() {
        return jdbc.queryForList("SELECT * FROM vw_appointment_details " +
            "ORDER BY appointment_date, appointment_time");
    }

    @GetMapping("/admissions")
    public List<Map<String, Object>> admissions() {
        return jdbc.queryForList("SELECT * FROM vw_current_admissions");
    }

    @GetMapping("/prescriptions")
    public List<Map<String, Object>> prescriptions() {
        return jdbc.queryForList("SELECT * FROM vw_prescription_details");
    }

    @GetMapping("/billing")
    public List<Map<String, Object>> billing() {
        return jdbc.queryForList("SELECT * FROM vw_billing_summary " +
            "ORDER BY pending_amount DESC");
    }
}