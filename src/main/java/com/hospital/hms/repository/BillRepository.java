package com.hospital.hms.repository;
import com.hospital.hms.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BillRepository extends JpaRepository<Bill, Integer> { }