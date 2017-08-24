package com.thewhite.sstuapp.domain;
import com.thewhite.sstuapp.domain.enumeration.QuestionStatusEnum;
import com.thewhite.sstuapp.domain.support.AbstractAuditableEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Обработка обращения.
 */
@Entity
public @Data
class Processing extends AbstractAuditableEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    private Department department;

    @ManyToOne(optional = false)
    private Question question;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuestionStatusEnum status;

    @Column(nullable = true)
    private Boolean isActionTaken;

    @Column(nullable = true)
    private Date responseDate;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Attachment attachment;

    @Embedded
    private ProcessingTransfer transfer;
}
