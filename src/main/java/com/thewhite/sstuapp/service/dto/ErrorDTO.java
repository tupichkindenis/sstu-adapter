package com.thewhite.sstuapp.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * Created by tupichkindenis on 17.08.17.
 */
@Getter
@AllArgsConstructor
public class ErrorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Ошибка", position = 1)
    @JsonProperty("message")
    private final String message;

    @ApiModelProperty(value = "Описание ошибки", position = 2)
    @JsonProperty("description")
    private final String description;

}
