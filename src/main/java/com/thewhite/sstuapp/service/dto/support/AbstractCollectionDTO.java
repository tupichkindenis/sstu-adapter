package com.thewhite.sstuapp.service.dto.support;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by tupichkindenis on 25.08.17.
 */
@Data
@SuppressWarnings("unused")
public abstract class AbstractCollectionDTO<T> {
    @ApiModelProperty(value = "Коллекция элементов.", position = 1)
    @JsonProperty("elements")
    private Collection<T> items = new ArrayList<>();
}
