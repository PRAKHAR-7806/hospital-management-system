package com.hospital.hms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "appointment")
@AttributeOverride(name = "id", column = @Column(name = "appointment_id"))
public class Appointment extends BaseEntity {

    @NotNull(message = "Patient is required")
    private Integer patientId;

    @NotNull(message = "Doctor is required")
    private Integer doctorId;

    @NotNull(message = "Date is required")
    private LocalDate appointmentDate;

    @NotNull(message = "Time is required")
    private LocalTime appointmentTime;

    private String reason;

    @NotBlank
    private String status = "Scheduled";
}