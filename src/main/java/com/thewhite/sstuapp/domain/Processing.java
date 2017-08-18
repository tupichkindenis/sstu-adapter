package com.thewhite.sstuapp.domain;
import com.thewhite.sstuapp.domain.enumeration.QuestionStatusEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * Обработка обращения.
 */
@Entity
@Table(name = "processing")
@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Processing extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private QuestionStatusEnum status;

    @ManyToOne
    @JoinTable(name = "transfer_department_id")
    private Department transferDepartment;

    @Column(name = "transfer_number")
    private String transferNumber;

    @Column(name = "transfer_time")
    private Instant transferTime;

    @Column(name = "is_action_taken")
    private Boolean isActionTaken;

    @Column(name = "response_date")
    private Instant responseDate;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Attachment attachment;

}
