package com.thewhite.sstuapp.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public @Data
class PagedRequestsDTO extends RequestsDTO {

    @ApiModelProperty(value = "Общее колличество найденных элементов.", position = 100)
    @JsonProperty("totalItems")
    private Integer totalItems = null;

    @ApiModelProperty(value = "Колличество страниц.", position = 100)
    @JsonProperty("totalPages")
    private Integer totalPages = null;

    @ApiModelProperty(value = "Колличество элементов на странице.", position = 100)
    @JsonProperty("pageSize")
    private Integer pageSize = null;

    @ApiModelProperty(value = "Текущая страница.", position = 100)
    @JsonProperty("currentPage")
    private Integer currentPage = null;

}
