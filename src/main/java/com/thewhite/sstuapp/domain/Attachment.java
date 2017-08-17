package com.thewhite.sstuapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by tupichkindenis on 15.08.17.
 */
@Entity
@Table(name = "attachment")
@Setter
@Getter
@NoArgsConstructor
public class Attachment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "external_id", nullable = false)
    private Long externalId;

    @NotNull
    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "mime_type")
    private String mimeType;

    @Column(name = "size")
    private Integer size;

}
