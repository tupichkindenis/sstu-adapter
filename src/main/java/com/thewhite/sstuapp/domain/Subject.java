package com.thewhite.sstuapp.domain;

import com.thewhite.sstuapp.domain.support.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

/**
 * Subject entity class.
 *
 * @author tupichkindenis
 */
@Entity
public @Data
class Subject extends AbstractEntity {
    @Column(length = 25, nullable = false)
    private String code;
    @Column(length = 4, nullable = false)
    private String code0;
    @Column(length = 4, nullable = false)
    private String code1;
    @Column(length = 4, nullable = false)
    private String code2;
    @Column(length = 4, nullable = false)
    private String code3;
    @Column(length = 4)
    private String subCode;
    @Column(length = 1024, nullable = false)
    private String name;
    @Column
    private Boolean isDeprecated;
}
