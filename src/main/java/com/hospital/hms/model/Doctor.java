package com.hospital.hms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "doctor")
@AttributeOverride(name = "id", column = @Column(name = "doctor_id"))
public class Doctor extends Person {

    private String email;
    private String specialization;

    @NotNull(message = "Department is required")
    private Integer departmentId;

    @Override
    public String getFullName() {
        return "Dr. " + firstName + " " + lastName;
    }
}