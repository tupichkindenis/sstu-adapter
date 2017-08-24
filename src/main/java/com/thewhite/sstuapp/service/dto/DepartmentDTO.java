package com.thewhite.sstuapp.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


/**
 * Created by tupichkindenis on 16.08.17.
 */
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public
class DepartmentDTO {

    @ApiModelProperty(example = "89729055-843A-4EEB-88E1-71535B245D6F", required = true, value = "Идентификатор департамента.", position = 1)
    @JsonProperty(value = "uuid", required = true)
    private String uuid;

    @ApiModelProperty(example = "Комитет Правительства Хабаровского края", required = true, value = "Наименование департамента.", position = 2)
    @JsonProperty(value = "name", required = true)
    private String name;
}
