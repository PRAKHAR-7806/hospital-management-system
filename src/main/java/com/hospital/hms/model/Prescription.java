package com.hospital.hms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "prescription")
@AttributeOverride(name = "id", column = @Column(name = "prescription_id"))
public class Prescription extends BaseEntity {

    @NotNull private Integer appointmentId;
    @NotNull private LocalDate prescriptionDate;
    private String notes;
}