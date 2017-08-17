package com.thewhite.sstuapp.repository;

import com.thewhite.sstuapp.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tupichkindenis on 15.08.17.
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {
}

