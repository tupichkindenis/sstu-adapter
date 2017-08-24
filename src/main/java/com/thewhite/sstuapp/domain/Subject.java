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
 * Created by tupichkindenis on 15.08.17.
 */
@Entity
public @Data
class Subject extends AbstractEntity {

    @Column(nullable = false)
    private UUID recordUuid;

    @Column(nullable = false)
    private String code;

    @Column(length = 4, nullable = false)
    private String shortCode;

    @Column(length = 1024, nullable = false)
    private String name;

    @Column(name = "deprecated", nullable = false)
    private Boolean isDeprecated;
}
