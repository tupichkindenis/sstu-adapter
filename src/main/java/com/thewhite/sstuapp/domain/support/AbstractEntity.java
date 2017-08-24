package com.thewhite.sstuapp.domain.support;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

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

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @Id
    private UUID uuid;
}
