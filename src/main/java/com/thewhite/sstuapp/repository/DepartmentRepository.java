package com.thewhite.sstuapp.repository;

import com.thewhite.sstuapp.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

