package com.thewhite.sstuapp.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tupichkindenis on 24.08.17.
 */
public @Data
class DepartmentsDTO {
    @ApiModelProperty(value = "Коллекция элементов.", position = 1)
    @JsonProperty("items")
    private List<DepartmentDTO> elements = new ArrayList<>();
}
