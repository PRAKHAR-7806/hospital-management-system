package com.hospital.hms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "test_result")
@AttributeOverride(name = "id", column = @Column(name = "result_id"))
public class TestResult extends BaseEntity {

    @NotNull private Integer patientId;
    @NotNull private Integer labTestId;
    @NotNull private Integer appointmentId;
    private String resultValue;
    private String remarks;
    @NotNull private LocalDate testDate;
}