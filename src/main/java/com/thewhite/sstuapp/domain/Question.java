package com.thewhite.sstuapp.domain;

import com.thewhite.sstuapp.domain.enumeration.QuestionStatusEnum;
import com.thewhite.sstuapp.domain.support.AbstractImportableEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Вопрос содержащийся в обрашении.
 */
@Entity
public @Data
class Question extends AbstractImportableEntity {

    private static final long serialVersionUID = 1L;

    /**
     *  Родительское обращение.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Request request;

    /**
     * Вопрос из Типового общероссийского тематического классификатора обращений граждан,
     * организаций и общественных объединений.
     */
    @ManyToOne(optional = false)
    private Subject subject;

    /**
     * Статус вопроса.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuestionStatusEnum status;

    //
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Processing> processings;

}
