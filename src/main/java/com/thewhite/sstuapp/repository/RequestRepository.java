package com.thewhite.sstuapp.repository;

import com.thewhite.sstuapp.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tupichkindenis on 15.08.17.
 */
public interface RequestRepository extends JpaRepository<Request, Long> {
}
