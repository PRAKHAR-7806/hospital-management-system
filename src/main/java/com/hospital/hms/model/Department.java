package com.hospital.hms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "department")
@AttributeOverride(name = "id", column = @Column(name = "department_id"))
public class Department extends BaseEntity {

    @NotBlank(message = "Department name is required")
    private String departmentName;

    private String location;
    private String phone;
}