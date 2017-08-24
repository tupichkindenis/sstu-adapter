package com.thewhite.sstuapp.repository;

import com.thewhite.sstuapp.domain.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by tupichkindenis on 15.08.17.
 */
public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
}

