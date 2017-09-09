package com.thewhite.sstuapp.domain.support;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public @Data
abstract class AbstractImportableEntity extends AbstractAuditableEntity {
    @Column(nullable = false, unique = true)
    private Long externalId;
}
