package com.thewhite.sstuapp.web.rest;
import com.thewhite.sstuapp.domain.enumeration.QuestionStatusEnum;
import com.thewhite.sstuapp.domain.enumeration.RequestFormatEnum;
import com.thewhite.sstuapp.domain.enumeration.UploadStatusEnum;
import com.thewhite.sstuapp.service.dto.*;
import com.thewhite.sstuapp.service.dto.department.DepartmentDTO;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;


/**
 * Created by tupichkindenis on 16.08.17.
 */
@RestController
@RequestMapping("/handling-report")
@Api(value = "Handling report", description = "Handling report api")
public class HandlingReportResource {

    /**
     *
     * @param id
     * @param depID
     * @param isDirect
     * @param numberFilter
     * @param createDateFrom
     * @param createDateTo
     * @param incomingDateFrom
     * @param incomingDateTo
     * @param registrationDateFrom
     * @param registrationDateTo
     * @param registrationNumberFilter
     * @param status
     * @param codeFilter
     * @param transferDepartmentID
     * @param transferDateFrom
     * @param transferDateTo
     * @param transferNumberFilter
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @ApiOperation(
            value = "Получение пейдженированного отчета о загруженных обрашениях",
            notes = "Получение пейджинированного списка вопросов. Поддерживается фильтрация по различным полям.",
            response = PagedRequestsDTO.class, tags = {"Handling report service"} )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = PagedRequestsDTO.class)
    })
    @RequestMapping(value = "/getData", produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<PagedRequestsDTO> getPageData(
            @ApiParam(value = "ID обращения", type = "long")                                                        @RequestParam(value = "id", required = false) Long id,
            @ApiParam(value = "ID департамента, выгрузившего обращения.", type = "string", format = "GUID")         @RequestParam(value = "departmentUuid", required = false) String depID,
            @ApiParam(value = "Только обращения поступившие напрямую от заявитеоя.", type = "boolean")              @RequestParam(value = "direct", required = false, defaultValue = "false") Boolean isDirect,
            @ApiParam(value = "Рег. № сопровод. документа")                                                         @RequestParam(value = "numberFilter", required = false) String numberFilter,
            @ApiParam(value = "Дата документа, с...", type = "string", format = "date")                             @RequestParam(value = "createDateFrom", required = false) String createDateFrom,
            @ApiParam(value = "Дата документа, по...", type = "string", format = "date", example = "2016-11-15")    @RequestParam(value = "createDateTo", required = false)   String createDateTo,
            @ApiParam(value = "Дата поступления в орган, с...", type = "string", format = "date")                   @RequestParam(value = "incomingDateFrom", required = false) String incomingDateFrom,
            @ApiParam(value = "Дата поступления в орган, по...", type = "string", format = "date")                  @RequestParam(value = "incomingDateTo", required = false) String incomingDateTo,
            @ApiParam(value = "Дата регистрации в органе, с...", type = "string", format = "date")                  @RequestParam(value = "registrationDateFrom", required = false) String registrationDateFrom,
            @ApiParam(value = "Дата регистрации в органе, по...", type = "string", format = "date")                 @RequestParam(value = "registrationDateTo", required = false) String registrationDateTo,
            @ApiParam(value = "Рег. № документа в органе", type = "string")                                         @RequestParam(value = "registrationNumberFilter", required = false) String registrationNumberFilter,
            @ApiParam(value = "Статус", type = "string")                                                            @RequestParam(value = "status", required = false) String status,
            @ApiParam(value = "Код вопроса", type = "string")                                                       @RequestParam(value = "codeFilter", required = false) String codeFilter,
            @ApiParam(value = "ID департамента, куда перенаправлен вопрос", type = "string", format = "UUID")       @RequestParam(value = "transferDepartmentID", required = false) String transferDepartmentID,
            @ApiParam(value = "Дата направления вопроса, с...")                                                     @RequestParam(value = "transferDateFrom", required = false) String transferDateFrom,
            @ApiParam(value = "Дата направления вопроса, по...")                                                    @RequestParam(value = "transferDateTo", required = false) String transferDateTo,
            @ApiParam(value = "Рег. # исходящего сопровод. документа.")                                             @RequestParam(value = "transferNumberFilter", required = false) String transferNumberFilter,
            //
            @ApiParam(value = "Размер страницы", defaultValue = "20")                                               @RequestParam(value = "pageSize", required = false, defaultValue="20") Integer pageSize,
            @ApiParam(value = "Номер страницы.", defaultValue = "0")                                                @RequestParam(value = "pageNumber", required = false, defaultValue="0") Integer pageNumber) {


        ProcessingDTO processingDTO_1 = new ProcessingDTO();
        processingDTO_1.setId(999L);
        processingDTO_1.setStatus(QuestionStatusEnum.InWork);
        processingDTO_1.setLastModifiedDateTimeUtc(new Date());

        ProcessingDTO processingDTO_2 = new ProcessingDTO();
        processingDTO_2.setId(998L);
        processingDTO_2.setStatus(QuestionStatusEnum.Answered);
        processingDTO_2.setIsActionTaken(true);
        processingDTO_2.setResponseDate(new Date());
        processingDTO_2.setAttachment(AttachmentDTO.builder().fileName("Ответ на обращение.docx").id(123L).mimeType("docx").size(1024L).build());
        processingDTO_2.setUploadStatus(UploadStatusEnum.Success);
        processingDTO_2.setLastModifiedDateTimeUtc(new Date());

        ProcessingDTO processingDTO_3 = new ProcessingDTO();
        processingDTO_3.setId(998L);
        processingDTO_3.setStatus(QuestionStatusEnum.Transferred);
        processingDTO_3.setTransfer(TransferDTO.builder().date(new Date()).number("123456-AB").department(DepartmentDTO.builder().name("Комитет Правительства Хабаровского края").uuid(UUID.randomUUID().toString()).build()).build());
        processingDTO_3.setUploadStatus(UploadStatusEnum.Error);
        processingDTO_3.setLastModifiedDateTimeUtc(new Date());
        processingDTO_3.setErrorMessage("Что то пошло не так...");

        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setCode("0134");
        questionDTO.setId(12345L);
        questionDTO.getProcessingList().add(processingDTO_1);
        questionDTO.getProcessingList().add(processingDTO_2);
        questionDTO.getProcessingList().add(processingDTO_3);

        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setId(42L);
        requestDTO.setDepartment(DepartmentDTO.builder().name("Комитет Правительства Хабаровского края").uuid(UUID.randomUUID().toString()).build());
        requestDTO.setFormat(RequestFormatEnum.Electronic);
        requestDTO.setNumber("А26-00-000000000");
        requestDTO.setCreateDate(new Date());
        requestDTO.setRegistrationNumber("Ж15-Д123");
        requestDTO.setRegistrationDate(new Date());
        requestDTO.setIncomingDate(new Date());
        requestDTO.setName("Иванов Иван Иванович");
        requestDTO.setAddress("г. Калуга, ул. Циолковского, д.8");
        requestDTO.setEmail("user@hostname.com");
        requestDTO.getQuestionList().add(questionDTO);

        PagedRequestsDTO result = new PagedRequestsDTO();
        result.getItems().add(requestDTO);


        result.setCurrentPage(0);
        result.setPageSize(20);
        result.setTotalItems(result.getItems().size());
        result.setTotalPages(1);



        return ResponseEntity.ok(result);
    }

}
