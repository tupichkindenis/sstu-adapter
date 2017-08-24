package com.thewhite.sstuapp.repository;

import com.thewhite.sstuapp.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentRepository extends JpaRepository<Department, UUID> {
}

