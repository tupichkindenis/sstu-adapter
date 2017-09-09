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
class Processing extends AbstractAuditableEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Орган в котором происходит работа с обрашением.
     */
    @ManyToOne(optional = false)
    private Department department;

    /**
     * Обращение.
     */
    @ManyToOne(optional = false)
    private Request request;

    /**
     * Вопрос.
     */
    @ManyToOne(optional = false)
    private Question question;

    /**
     * Статус вопроса. Один вопрос может обладать несколькими статусами.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuestionStatusEnum status;

    /**
     * Признак того, что меры были приняты.
     */
    @Column
    private Boolean isActionTaken;

    /**
     * Дата ответа заявителю.
     */
    @Column
    @Temporal(TemporalType.DATE)
    private Date responseDate;

    /**
     * Информация содержащая ответ заявителю.
     */
    @Embedded
    private ProcessingAttachment processingAttachment;

    /**
     * Информация содержащая данные о перенаправлении вопроса в другой орган.
     */
    @Embedded
    private ProcessingTransfer transfer;
}
