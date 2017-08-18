package com.thewhite.sstuapp.web.rest;
import com.thewhite.sstuapp.domain.enumeration.QuestionStatusEnum;
import com.thewhite.sstuapp.domain.enumeration.RequestFormatEnum;
import com.thewhite.sstuapp.domain.enumeration.UploadStatusEnum;
import com.thewhite.sstuapp.service.dto.*;
import io.swagger.annotations.*;
import io.undertow.util.DateUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


/**
 * Created by tupichkindenis on 16.08.17.
 */
@RestController
@RequestMapping("/handling-report")
@Api(value = "Handling report", description = "Handling report api")
public class HandlingReportResource {

    @ApiOperation(
            value = "Получение пейдженированного отчета о загруженных обрашениях",
            notes = "Получение пейджинированного списка вопросов. Поддерживается фильтрация по различным полям.",
            response = PagedRequestsDTO.class, tags = {"Handling report service"} )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = PagedRequestsDTO.class),
            @ApiResponse(code = 400, message = "The request was invalid or cannot be otherwise served.", response = ErrorDTO.class),
            @ApiResponse(code = 401, message = "Authentication credentials were missing or incorrect.", response = ErrorDTO.class),
            @ApiResponse(code = 403, message = "The request is understood, but it has been refused or access is not allowed.", response = ErrorDTO.class),
            @ApiResponse(code = 404, message = "The URI requested is invalid or the resource requested does not exists.", response = ErrorDTO.class),
            @ApiResponse(code = 409, message = "Any message which should help the user to resolve the conflict.", response = ErrorDTO.class),
            @ApiResponse(code = 429, message = "The request cannot be served due to the application’s rate limit having been exhausted for the resource.", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Something is broken.", response = ErrorDTO.class),
            @ApiResponse(code = 503, message = "The server is up, but overloaded with requests. Try again later.", response = ErrorDTO.class) })
    @RequestMapping(value = "/get-page-data", produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<PagedRequestsDTO> getPageData(
            @ApiParam(value = "Размер страницы", defaultValue = "20") @RequestParam(value = "pageSize", required = false, defaultValue="20") Integer pageSize,
            @ApiParam(value = "Номер страницы.", defaultValue = "0") @RequestParam(value = "pageNumber", required = false, defaultValue="0") Integer pageNumber) {


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
