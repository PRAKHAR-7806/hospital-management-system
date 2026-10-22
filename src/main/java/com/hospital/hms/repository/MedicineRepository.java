package com.hospital.hms.repository;
import com.hospital.hms.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MedicineRepository extends JpaRepository<Medicine, Integer> { }
