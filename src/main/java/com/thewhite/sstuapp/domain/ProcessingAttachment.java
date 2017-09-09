package com.thewhite.sstuapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public @Data
class ProcessingAttachment implements Serializable {

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String fileMimeType;

    @Column(nullable = false)
    private Integer fileSize;

}
