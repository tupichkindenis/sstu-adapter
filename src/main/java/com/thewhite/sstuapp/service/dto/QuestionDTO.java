package com.thewhite.sstuapp.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thewhite.sstuapp.domain.Processing;
import com.thewhite.sstuapp.domain.enumeration.QuestionStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class QuestionDTO {

    @ApiModelProperty(
            value = "Уникальный идентификатор вопроса.",
            required = true,
            example = "123",
            position = 1)
    @JsonProperty("id")
    private Long id = null;

    @ApiModelProperty(
            value = "Идентификатор обращения содержащего данный вопрос.",
            required = true,
            example = "123",
            position = 2)
    @JsonProperty("request_id")
    private Long requestId = null;

    @ApiModelProperty(
            value = "Код вопроса, содержащегося в обращении, в соответствии с типовым общероссийским тематическим " +
                    "классификатором обращения граждан, организаций и общественных объединений, в том числе " +
                    "дополнительно выявленного органом.",
            required = true,
            example = "0455",
            position = 3)
    @JsonProperty("code")
    private String code = null;

    @ApiModelProperty(
            value = "Массив данных об обработке вопроса в органе.",
            position = 4)
    @JsonProperty("processingList")
    private List<ProcessingDTO> processingList = new ArrayList<>();
}
