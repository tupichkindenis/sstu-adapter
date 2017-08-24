package com.thewhite.sstuapp.export.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import java.util.UUID;

@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public @Data class SstuTransfer {
    @JsonProperty(value = "departmentId")
    private UUID departmentId;
    @JsonProperty(value = "transferDate")
    private Date transferDate;
    @JsonProperty(value = "transferNumber")
    private String transferNumber;
}
