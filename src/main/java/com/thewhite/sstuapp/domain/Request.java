package com.thewhite.sstuapp.domain;

import com.thewhite.sstuapp.domain.enumeration.RequestFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


/**
 * Обращение.
 */
@Entity
@Table(name = "request")
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class Request extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Идентификатор обращения.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Идентификатор обращения в СЭД.
     */
    @NotNull
    @Column(name = "external_id", nullable = false)
    private Long externalId;

    /**
     * Орган, в котором происходит работа над обращением.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    /**
     * Определяет, поступило ли обращение напрямую непосредственно от заявителя.
     */
    @Column(name = "is_direct")
    private boolean isDirect = true;

    /**
     * Формат обращения.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "format")
    private RequestFormat format = RequestFormat.Electronic;

    /**
     * Регистрационный номер сопроводительного письма, с которым обращение поступило из Управления Президента
     * Российской Федерации по работе с обращениями граждан и организаций (далее — УРОГ) или иного органа власти.
     * Или номер обращения, присвоенный при регистрации в органе власти, если обращение поступило напрямую
     * непосредственно от заявителя.
     */
    @Column(name = "number", nullable = false)
    private String number;

    /**
     * Дата регистрации сопроводительного письма, с которым обращение поступило из УРОГ или иного органа власти.
     * Необязательное, если isDirect = true
     */
    @Column(name = "create_date")
    private Instant createDate;

    /**
     * Строка, ФИО заявителя.
     *
     */
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Почтовый адрес заявителя.
     * Строка, необязательное.
     */
    @Column(name = "address")
    private String address;

    /**
     * Адрес электронной почты заявителя.
     * Строка, необязательное.
     */
    @Column(name = "email")
    private String email;

    /**
     * Массив данных об обработке вопросов в данном органе (далее — вопросы).
     * Должен быть указан хотя бы один вопрос.
     */
    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();


}
