package com.hospital.hms.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Person extends BaseEntity {

    @NotBlank(message = "First name is required")
    protected String firstName;

    @NotBlank(message = "Last name is required")
    protected String lastName;

    @NotBlank(message = "Phone is required")
    protected String phone;

    public abstract String getFullName();
}