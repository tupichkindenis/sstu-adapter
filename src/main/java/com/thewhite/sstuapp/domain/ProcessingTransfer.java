package com.thewhite.sstuapp.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.Instant;

@Embeddable
public @Data
class ProcessingTransfer implements Serializable {

    @ManyToOne(optional = true)
    private Department transferDepartment;

    @Column(nullable = true)
    private String transferNumber;

    @Column(nullable = true)
    private Instant transferTime;
}
