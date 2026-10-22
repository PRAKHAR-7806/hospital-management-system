package com.hospital.hms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "bill")
@AttributeOverride(name = "id", column = @Column(name = "bill_id"))
public class Bill extends BaseEntity {

    @NotNull private Integer patientId;
    @NotNull private LocalDate billDate;
    @NotNull private BigDecimal totalAmount;
    private String paymentStatus = "Pending";
}   