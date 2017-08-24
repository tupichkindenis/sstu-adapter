package com.thewhite.sstuapp.domain;

import com.thewhite.sstuapp.domain.enumeration.RequestFormatEnum;
import com.thewhite.sstuapp.domain.support.AbstractImportableEntity;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Обращение.
 */
@Entity
public @Data
class Request extends AbstractImportableEntity {

    /**
     * Орган, в котором происходит работа над обращением.
     */
    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    private Department department;

    /**
     * Определяет, поступило ли обращение напрямую непосредственно от заявителя.
     */
    @Column(nullable = false)
    private Boolean isDirect;

    /**
     * Формат обращения.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "format")
    private RequestFormatEnum format = RequestFormatEnum.Electronic;

    /**
     * Регистрационный номер сопроводительного письма, с которым обращение поступило из Управления Президента
     * Российской Федерации по работе с обращениями граждан и организаций (далее — УРОГ) или иного органа власти.
     * Или номер обращения, присвоенный при регистрации в органе власти, если обращение поступило напрямую
     * непосредственно от заявителя.
     */
    @Column(nullable = false)
    private String number;

    /**
     * Дата регистрации сопроводительного письма,
     * с которым обращение поступило из УРОГ или иного органа власти.
     * Необязательное, если isDirect = true
     */
    @Column()
    private Date createDate;

    /**
     * Строка, ФИО заявителя.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Почтовый адрес заявителя. Строка, необязательное.
     */
    @Column()
    private String address;

    /**
     * Адрес электронной почты заявителя.
     * Строка, необязательное.
     */
    @Column(nullable = false)
    private String email;

    /**
     * Массив данных об обработке вопросов в данном органе (далее — вопросы).
     * Должен быть указан хотя бы один вопрос.
     */
    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();


}
