package com.hospital.hms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "patient")
@AttributeOverride(name = "id", column = @Column(name = "patient_id"))
public class Patient extends Person {

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Gender is required")
    private String gender;

    private String bloodGroup;
    private String address;

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }
}