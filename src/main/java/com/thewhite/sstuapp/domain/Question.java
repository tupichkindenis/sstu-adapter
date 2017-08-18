package com.thewhite.sstuapp.domain;

import com.thewhite.sstuapp.domain.enumeration.QuestionStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Вопрос содержащийся в обрашении.
 */
@Entity
@Table(name = "question")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Question extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Идентификатор вопроса.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Вопрос из Типового общероссийского тематического классификатора обращений граждан, организаций и общественных
     * объединений.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    /**
     * Статус вопроса.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private QuestionStatusEnum status;


    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Processing> processings = new ArrayList<>();

    /**
     * Обращение.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;

}
