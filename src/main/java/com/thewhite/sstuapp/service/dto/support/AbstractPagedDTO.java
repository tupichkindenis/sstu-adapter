package com.thewhite.sstuapp.service.dto.support;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by tupichkindenis on 25.08.17.
 */
@Data
@SuppressWarnings("unused")
public abstract class AbstractPagedDTO<T> extends AbstractCollectionDTO<T> {
    @ApiModelProperty(value = "Общее колличество элементов.", position = 100)
    @JsonProperty("totalItems")
    private Long totalElements;

    @ApiModelProperty(value = "Колличество страниц.", position = 101)
    @JsonProperty("totalPages")
    private Integer totalPages;
}
