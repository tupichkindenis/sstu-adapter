package com.thewhite.sstuapp.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

/**
 * Created by tupichkindenis on 16.08.17.
 */
public class TransferDTO {

    @ApiModelProperty(value = "Идентификатор органа в адрес которого был направлен вопрос (Используется только для статуса Transferred).", required = true, position = 1)
    @JsonProperty("department")
    private DepartmentDTO department;

    @ApiModelProperty(value = "Регистрационный номер исходящего сопроводительного документа при направлении вопроса, содержащегося в обращении, в иной орган (учереждение, организацию).", required = true, position = 2, example = "123456-AB")
    @JsonProperty("number")
    private String number = null;

    @ApiModelProperty(example = "2016-11-18", value = "Дата направления вопроса, содержащегося в обращении, в иной орган (учреждение, организацию)", required = true, position = 3)
    @JsonProperty("date")
    private LocalDate date = null;

}
