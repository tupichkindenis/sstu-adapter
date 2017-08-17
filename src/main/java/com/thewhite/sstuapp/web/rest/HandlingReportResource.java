package com.thewhite.sstuapp.web.rest;

import com.sun.tools.javac.util.ArrayUtils;
import com.thewhite.sstuapp.domain.Department;
import com.thewhite.sstuapp.service.dto.ErrorDTO;
import com.thewhite.sstuapp.service.dto.PagedRequestsDTO;
import com.thewhite.sstuapp.service.dto.RequestDTO;
import io.swagger.annotations.*;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

        // some magic

        return ResponseEntity.ok(new PagedRequestsDTO());
    }

}
