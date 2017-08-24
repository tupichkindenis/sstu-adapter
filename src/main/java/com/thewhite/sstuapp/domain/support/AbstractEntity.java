package com.thewhite.sstuapp.domain.support;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by tupichkindenis on 24.08.17.
 */
@MappedSuperclass
public @Data
abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "ID", unique = true, nullable = false, insertable = true, updatable = false, length = 36, precision = 0)
    private UUID id;
}
