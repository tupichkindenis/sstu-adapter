package com.thewhite.sstuapp.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by tupichkindenis on 16.08.17.
 */
@Setter
@Getter
@Builder
public class AttachmentDTO {

    @ApiModelProperty(value = "Идентификатор файла вложения.", required = true, example = "123", position = 1)
    @JsonProperty(value = "id", required = true, index = 1)
    private Long id = null;

    @ApiModelProperty(value = "Имя файла.", required = true, example = "Ответ на обращение.docx", position = 2)
    @JsonProperty(value = "fileName", required = true, index = 2)
    private String fileName = null;

    @ApiModelProperty(value = "Тип файла.", example = "docx", position = 3)
    @JsonProperty(value ="mimeType", index = 3)
    private String mimeType = null;

    @ApiModelProperty(value = "Размер файла (в байтах.)", required = true, example = "1024", position = 4)
    @JsonProperty(value = "size", required = true, index = 4)
    private Long size = null;
}
