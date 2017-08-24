package com.thewhite.sstuapp.domain;

import com.thewhite.sstuapp.domain.support.AbstractImportableEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
public @Data
class Attachment extends AbstractImportableEntity {

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String mimeType;

    @Column(nullable = false)
    private Integer size;

}
