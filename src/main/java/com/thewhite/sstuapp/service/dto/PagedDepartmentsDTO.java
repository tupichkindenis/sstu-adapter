package com.thewhite.sstuapp.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by tupichkindenis on 24.08.17.
 */
@SuppressWarnings("unused")
public @Data
class PagedDepartmentsDTO extends DepartmentsDTO {

    @ApiModelProperty(value = "Общее колличество элементов.", position = 100)
    @JsonProperty("totalItems")
    private Long totalElements = null;

    @ApiModelProperty(value = "Колличество страниц.", position = 101)
    @JsonProperty("totalPages")
    private Integer totalPages = null;

    @ApiModelProperty(value = "Колличество элементов на странице.", position = 102)
    @JsonProperty("pageSize")
    private Integer pageSize = null;

    @ApiModelProperty(value = "Текущая страница.", position = 103)
    @JsonProperty("currentPage")
    private Integer currentPage = null;
}
