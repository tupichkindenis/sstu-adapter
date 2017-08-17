package com.thewhite.sstuapp.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thewhite.sstuapp.domain.enumeration.RequestFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class RequestDTO {

    @ApiModelProperty(
            value = "Идентификатор обращения в СЭД.",
            required = true,
            example = "123456",
            position = 1)
    @JsonProperty("id")
    private Long id = null;


    @ApiModelProperty(
            value = "Департамент осуществляющий выгрузку обращения.",
            required = true,
            position = 2)
    @JsonProperty("department")
    private DepartmentDTO department = null;

    @ApiModelProperty(
            value = "Формат обращения.",
            required = true,
            example = "Electronic",
            allowableValues = "Electronic,Other",
            position = 3)
    @JsonProperty("format")
    private RequestFormat format = null;

    @ApiModelProperty(
            value = "Регистрационный номер сопроводительного письма, с которым обращение поступило из " +
                    "Управления Президента Российской Федерации по работе с обращениями граждан и организаций (далее — УРОГ) " +
                    "или иного органа власти.",
            example = "А26-00-000000000",
            position = 4)
    @JsonProperty("number")
    private String number = null;

    @ApiModelProperty(
            value = "Дата регистрации сопроводительного письма, с которым обращение поступило из УРОГ или " +
                    "иного органа власти. Необязательное, если обращение поступило напрямую в орган.",
            example = "2016-11-15",
            position = 5)
    @JsonProperty("createDate")
    private LocalDate createDate = null;

    @ApiModelProperty(
            value = "Дата поступления обращения в орган.",
            example = "2016-11-15",
            position = 6)
    @JsonProperty("incomingDate")
    private LocalDate incomingDate = null;

    @ApiModelProperty(
            value = "Дата регистрации обращения в органе.",
            example = "2016-11-15",
            position = 7)
    @JsonProperty("registrationDate")
    private LocalDate registrationDate = null;

    @ApiModelProperty(
            value = "Регистрационный номер, присвоенный обращению при регистрации в органе власти.",
            example = "Ж15-Д123",
            position = 8)
    @JsonProperty("registrationNumber")
    private String registrationNumber = null;

    @ApiModelProperty(
            value = "Строка, ФИО заявителя.",
            required = true,
            example = "Иванов Иван Иванович",
            position = 9)
    @NotNull @NotEmpty
    @JsonProperty("name")
    private String name = null;

    @ApiModelProperty(
            value = "Почтовый адрес заявителя.",
            example = "г. Калуга, ул. Циолковского, д.8",
            position = 10)
    @JsonProperty("address")
    private String address = null;

    @ApiModelProperty(
            value = "Адрес электронной почты заявителя.",
            example = "user@hostname.com",
            position = 11)
    @JsonProperty("email")
    private String email = null;

    @ApiModelProperty(
            value = "Массив данных об обработке вопросов в данном органе (далее — вопросы). Должен быть указан хотя " +
                    "бы один вопрос.",
            required = true,
            position = 12)
    @NotNull
    @JsonProperty("questionList")
    private List<QuestionDTO> questionList = new ArrayList<>();
}
