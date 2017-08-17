package com.thewhite.sstuapp.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tupichkindenis on 17.08.17.
 */
public class RequestsDTO {

    @ApiModelProperty(value = "Массив элементов.", position = 1)
    @JsonProperty("items")
    private List<RequestDTO> items = new ArrayList<RequestDTO>();

}
