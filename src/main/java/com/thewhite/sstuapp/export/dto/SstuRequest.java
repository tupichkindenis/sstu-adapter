package com.thewhite.sstuapp.export.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thewhite.sstuapp.domain.enumeration.RequestFormatEnum;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public @Data class SstuRequest {

    @JsonIgnore
    private Integer id;

    @JsonProperty(value = "departmentId")
    private UUID departmentId;

    @JsonProperty(value = "isDirect")
    private Boolean isDirect;

    @JsonProperty(value = "format")
    private RequestFormatEnum format;

    @JsonProperty(value = "number")
    private String number;

    @JsonProperty(value = "createDate")
    private Date createDate;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "address")
    private String address;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "questions")
    private List<SstuQuestion> questions;
}
