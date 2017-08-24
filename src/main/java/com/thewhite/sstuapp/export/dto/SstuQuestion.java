package com.thewhite.sstuapp.export.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thewhite.sstuapp.domain.enumeration.QuestionStatusEnum;
import lombok.Data;
import java.util.Date;


@JsonInclude(JsonInclude.Include.NON_NULL)
public @Data class SstuQuestion {
    @JsonProperty(value = "code")
    private String code;

    @JsonProperty(value = "status")
    private QuestionStatusEnum status;

    @JsonProperty(value = "incomingDate")
    private Date incomingDate;

    @JsonProperty(value = "registrationDate")
    private Date registrationDate;

    @JsonProperty(value = "responseDate")
    private Date responseDate;

    @JsonProperty(value = "actionsTaken")
    private Boolean actionsTaken;

    @JsonProperty(value = "transfer")
    private SstuTransfer transfer;

    @JsonProperty(value = "attachment")
    private SstuAttachment attachment;
}
