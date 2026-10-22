package com.hospital.hms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "lab_test")
@AttributeOverride(name = "id", column = @Column(name = "lab_test_id"))
public class LabTest extends BaseEntity {

    @NotBlank private String testName;
    @NotNull  private BigDecimal cost;
}