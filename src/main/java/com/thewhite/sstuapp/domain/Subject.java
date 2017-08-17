package com.thewhite.sstuapp.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by tupichkindenis on 15.08.17.
 */
@Entity
@Table(name = "subject")
@Setter
@Getter
@EqualsAndHashCode
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "code", length = 15, nullable = false)
    private String code;

    @Column(name = "name", length = 1024, nullable = false)
    private String name;

    @Column(name = "deprecated", nullable = false)
    private boolean deprecated = false;
}
