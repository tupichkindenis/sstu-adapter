package com.thewhite.sstuapp.web.rest;

import com.thewhite.sstuapp.domain.Department;
import com.thewhite.sstuapp.domain.Subject;
import com.thewhite.sstuapp.repository.SubjectRepository;
import com.thewhite.sstuapp.service.dto.department.DepartmentDTO;
import com.thewhite.sstuapp.service.dto.department.DepartmentsPagedCollectionDTO;
import com.thewhite.sstuapp.service.dto.subject.SubjectsCollectionDTO;
import com.thewhite.sstuapp.service.dto.subject.SubjectDTO;
import com.thewhite.sstuapp.service.dto.subject.SubjectsPagedCollectionDTO;
import com.thewhite.sstuapp.web.rest.exception.DepartmentNotFoundException;
import com.thewhite.sstuapp.web.rest.support.ApiError;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by tupichkindenis on 15.08.17.
 */
@RestController
@RequestMapping("/subjects")
public class SubjectResource {

    private static final int SUBJECT_MIN_LENGTH_TO_SEARCH = 2;

    @Autowired
    private SubjectRepository repository;

    /**
     * Получение информации о тематике по идентификатору.
     *
     * @param   uuid Идентификатор тематики
     * @return  Тематика
     */
    @ApiOperation(  value   = "Тематика.",
                    notes   = "Получение подробной информации о тематике.",
                    tags    = { "Subject service" } )
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Тематика.", response = DepartmentDTO.class),
                            @ApiResponse(code = 400, message = "Упс.", response = ApiError.class),
                            @ApiResponse(code = 404, message = "Тематика не найдена", response = ApiError.class) } )
    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity<SubjectDTO> getByUuid(
            @ApiParam(value = "Идентификатор тематики", type = "UUID") @PathVariable(value = "uuid") final UUID uuid) {

        Subject entity = repository.findOne(uuid);

        if (entity == null) {
            throw new DepartmentNotFoundException(uuid.toString());
        }

        SubjectDTO dto = SubjectDTO.builder()
                .uuid(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .build();

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Получение списка тематик.
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value    = "Список тематик.",
                  notes    = "Получение тематик пейджинированным списком", tags = {"Subject service"} )
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Коллекция тематик.", response = SubjectsPagedCollectionDTO.class),
                            @ApiResponse(code = 400, message = "Упс.", response = ApiError.class) } )
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity<SubjectsPagedCollectionDTO> getAll(
            // page
            @ApiParam(value = "Страница.", type = "int",defaultValue = "0")
            @RequestParam(value = "page", required = false, defaultValue =  "0") int page,
            // size
            @ApiParam(value = "Кол-во элементов.", type = "int", defaultValue = "20")
            @RequestParam(value = "size", required = false, defaultValue = "20") int size )
    {

        Page<Subject> departmentPage = repository.findAll(new PageRequest(page, size));

        SubjectsPagedCollectionDTO subjectsPagedCollectionDTO = new SubjectsPagedCollectionDTO();
        subjectsPagedCollectionDTO.setItems(departmentPage.getContent().stream().map( subject -> SubjectDTO.builder()
                .uuid(subject.getId())
                .name(subject.getName())
                .build()).collect(Collectors.toList()));

        subjectsPagedCollectionDTO.setTotalElements(departmentPage.getTotalElements());
        subjectsPagedCollectionDTO.setTotalPages(departmentPage.getTotalPages());

        return new ResponseEntity<>(subjectsPagedCollectionDTO, HttpStatus.OK);

    }

    /**
     * Поиск тематики.
     * @param searchString
     * @return
     */
    @ApiOperation(value   = "Поиск тематики.",
                  notes   = "Поиск тематики осуществляется по ее коду или наименованию.", tags = {"Subject service"} )
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Коллекция тематик.", response = SubjectsCollectionDTO.class),
                            @ApiResponse(code = 400, message = "Упс.", response = ApiError.class) } )
    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity<SubjectsCollectionDTO> search(
            @ApiParam(value = "Строка поиска.", type = "string" )
            @RequestParam(value = "searchString") String searchString ) {

        if ( searchString.length() < SUBJECT_MIN_LENGTH_TO_SEARCH ){
            return new ResponseEntity<>( new SubjectsCollectionDTO(), HttpStatus.OK );
        }

        SubjectsCollectionDTO subjectsCollectionDTO = new SubjectsCollectionDTO();
        subjectsCollectionDTO.setItems(repository
                .findTop10ByCode3StartsWithOrNameIgnoreCaseContainsOrderByCode3(searchString, searchString)
                .stream()
                .map( item -> SubjectDTO.builder()
                        .uuid(item.getId())
                        .code(item.getCode())
                        .name(item.getName())
                        .build()).collect(Collectors.toList()));

        return new ResponseEntity<>(subjectsCollectionDTO, HttpStatus.OK);
    }

}
