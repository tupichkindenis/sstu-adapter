package com.thewhite.sstuapp.domain;

import com.thewhite.sstuapp.domain.support.AbstractImportableEntity;
import lombok.*;

import javax.persistence.*;

/**
 * Вопрос содержащийся в обрашении.
 */
@Entity
@Table(name = "Questions")
public @Data
class Question extends AbstractImportableEntity {

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
}
