package com.hospital.hms.repository;
import com.hospital.hms.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> { }