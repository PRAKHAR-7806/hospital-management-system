package com.hospital.hms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "admission")
@AttributeOverride(name = "id", column = @Column(name = "admission_id"))
public class Admission extends BaseEntity {

    @NotNull private Integer patientId;
    @NotNull private Integer doctorId;
    @NotNull private LocalDate admissionDate;
    private LocalDate dischargeDate;
    @NotBlank private String roomNo;
    private String reason;
    private String status = "Admitted";
}