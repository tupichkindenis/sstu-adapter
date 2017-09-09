package com.thewhite.sstuapp.importing.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

/**
 * Request entity from EDM.
 *
 */
@Data
@SuppressWarnings("unused")
public final class RequestEntity {
    @JacksonXmlProperty(localName = "ID")
    private Long id;
    @JacksonXmlProperty(localName = "CREATED")
    private Date auditCreated;
    @JacksonXmlProperty(localName = "MODIFIED")
    private Date auditModified;
    @JacksonXmlProperty(localName = "CREATE")
    private Date create;
    @JacksonXmlProperty(localName = "DEPARTMENT_ID")
    private UUID departmentId;
    @JacksonXmlProperty(localName = "DIRECT")
    private String direct;
    @JacksonXmlProperty(localName = "FORMAT")
    private String format;
    @JacksonXmlProperty(localName = "REG_DATE")
    private Date regDate;
    @JacksonXmlProperty(localName = "REG_NUMBER")
    private String regNumber;
    @JacksonXmlProperty(localName = "LETTER_DATE")
    private Date letterDate;
    @JacksonXmlProperty(localName = "LETTER_NUMBER")
    private String letterNumber;
    @JacksonXmlProperty(localName = "NAME")
    private String name;
    @JacksonXmlProperty(localName = "ADDRESS")
    private String address;
    @JacksonXmlProperty(localName = "EMAIL")
    private String email;
}
