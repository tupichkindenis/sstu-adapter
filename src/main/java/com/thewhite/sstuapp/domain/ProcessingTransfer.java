package com.thewhite.sstuapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Embeddable
public @Data
class ProcessingTransfer implements Serializable {
    @ManyToOne
    private Department transferredTo;
    @Column
    private String transferNumber;
    @Column
    @Temporal(TemporalType.DATE)
    private Date transferTime;
}
