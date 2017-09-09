package com.thewhite.sstuapp.importing.office;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;
import java.util.UUID;

/**
 * Office entity from EDM.
 */
@Data
@SuppressWarnings("unused")
public final class OfficeEntity {
    @JacksonXmlProperty(localName = "ID")
    private long id;
    @JacksonXmlProperty(localName = "DEPARTMENT_ID")
    private UUID departmentId;
    @JacksonXmlProperty(localName = "NAME")
    private String name;
}
