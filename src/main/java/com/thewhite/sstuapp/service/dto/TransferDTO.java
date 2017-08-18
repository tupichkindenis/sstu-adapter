package com.thewhite.sstuapp.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by tupichkindenis on 16.08.17.
 */
@Getter
@Setter
@Builder
public class TransferDTO {

    @ApiModelProperty(value = "Идентификатор органа в адрес которого был направлен вопрос (Используется только для статуса Transferred).", required = true, position = 1)
    @JsonProperty("department")
    private DepartmentDTO department;

    @ApiModelProperty(value = "Регистрационный номер исходящего сопроводительного документа при направлении вопроса, содержащегося в обращении, в иной орган (учереждение, организацию).", required = true, position = 2, example = "123456-AB")
    @JsonProperty("number")
    private String number = null;

    @ApiModelProperty(example = "2016-11-18", value = "Дата направления вопроса, содержащегося в обращении, в иной орган (учреждение, организацию)", required = true, position = 3)
    @JsonProperty("date")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date date = null;

}
