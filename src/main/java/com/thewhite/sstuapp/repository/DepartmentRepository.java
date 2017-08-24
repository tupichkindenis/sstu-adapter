package com.thewhite.sstuapp.repository;

import com.thewhite.sstuapp.domain.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface DepartmentRepository extends PagingAndSortingRepository<Department, UUID> {
    Page<Department> findTo10ByNameIgnoreCaseContainsOrderByName(String name, Pageable paging);
}

