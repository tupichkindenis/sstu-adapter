package com.thewhite.sstuapp.repository;
import com.thewhite.sstuapp.domain.Department;
import com.thewhite.sstuapp.domain.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

/**
 * Created by tupichkindenis on 15.08.17.
 */
@SuppressWarnings("unused")
public interface SubjectRepository extends PagingAndSortingRepository<Subject, UUID> {
    List<Subject> findTop10ByCode3StartsWithOrNameIgnoreCaseContainsOrderByCode3(String code3, String name);
}


