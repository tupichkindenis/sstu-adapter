package com.thewhite.sstuapp.domain;

import com.thewhite.sstuapp.domain.support.AbstractEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
public @Data
class Department extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean isDeprecated;

}
