package com.hospital.hms.repository;
import com.hospital.hms.model.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AdmissionRepository extends JpaRepository<Admission, Integer> { }
