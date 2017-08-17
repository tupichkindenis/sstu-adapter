package com.thewhite.sstuapp.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thewhite.sstuapp.domain.enumeration.QuestionStatus;
import com.thewhite.sstuapp.domain.enumeration.UploadStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by tupichkindenis on 15.08.17.
 */
@Getter
@Setter
public class ProcessingDTO {

    @ApiModelProperty(
            value = "Идентификатор действия.",
            required = true,
            example = "123",
            position = 1)
    @JsonProperty("id")
    private Long id = null;

    @ApiModelProperty(
            value = "Идентификатор вопроса.",
            required = true,
            example = "123",
            position = 3)
    @JsonProperty("question_id")
    private Long questionId = null;

    @ApiModelProperty(
            value = "Текущий статус.",
            required = true,
            example = "NotReceived",
            allowableValues =
                    "NotReceived," +
                    "NotRegistered," +
                    "InWork," +
                    "Explained," +
                    "Supported," +
                    "NotSupported," +
                    "Transferred," +
                    "Answered," +
                    "LeftWithoutAnswer",
            position = 4)
    @JsonProperty("status")
    private QuestionStatus status;

    @ApiModelProperty(
            value = "Признак того были ли приняты меры или нет. (Используется для статуса Supported).",
            required = true,
            example = "true",
            position = 5)
    @JsonProperty("isActionTaken")
    private Boolean isActionTaken = null;

    @ApiModelProperty(
            value = "Дата регистрации ответа заявителю.",
            example = "2016-11-19",
            position = 5)
    @JsonProperty("responseDate")
    private LocalDate responseDate = null;

    @ApiModelProperty(
            value = "Информация о перенеправлении вопроса в другой орган.",
            position = 6)
    @JsonProperty("transfer")
    private TransferDTO transfer = null;

    @ApiModelProperty(
            value = "Идентификатор приложенного файла.",
            position = 7)
    @JsonProperty("attachment")
    private AttachmentDTO attachment = null;

    @ApiModelProperty(
            value = "Дата и время последнего обновления действия.",
            position = 8)
    @JsonProperty("lastModifiedDate")
    private LocalDateTime lastModifiedDateTime = null;

    @ApiModelProperty(
            value = "Статус выгрузки в ССТУ",
            required = true,
            example = "Warning",
            position = 9)
    @JsonProperty("uploadStatus")
    private UploadStatusEnum uploadStatus = UploadStatusEnum.None;

    @ApiModelProperty(
            value = "Текст ошибки.",
            example = "Файл вложения не найден.",
            position = 10)
    @JsonProperty("errorMessage")
    private String errorMessage = null;
}
