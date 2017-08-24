package com.thewhite.sstuapp.web.rest;

import com.thewhite.sstuapp.domain.Department;
import com.thewhite.sstuapp.repository.DepartmentRepository;
import com.thewhite.sstuapp.service.dto.DepartmentDTO;
import com.thewhite.sstuapp.service.dto.PagedDepartmentsDTO;
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
 * АПИ для работы с Департаментами.
 */
@RestController
@RequestMapping("/departments")
public class DepartmentResource {

    private static final int NAME_MIN_LENGTH_TO_SEARCH = 5;

    @Autowired
    private DepartmentRepository repository;

    /**
     * Получение департамента по идентификатору.
     * @param uuid Идентификатор обращения
     * @return Департамент
     */
    @ApiOperation(value = "Получение департамента по идентификатору.", tags = {"Department service"} )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Департамент.",           response = DepartmentDTO.class),
            @ApiResponse(code = 400, message = "Упс.",                   response = ApiError.class),
            @ApiResponse(code = 404, message = "Департамент не найден.", response = ApiError.class)
    })

    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public ResponseEntity<DepartmentDTO> getByUuid(
            @ApiParam(value = "Идентификатор обращения", type = "UUID") @PathVariable(value = "uuid") final UUID uuid) {

        Department department = repository.findOne(uuid);

        if (department == null) {
            throw new DepartmentNotFoundException(uuid.toString());
        }

        DepartmentDTO dto = DepartmentDTO.builder()
                .uuid(department.getId().toString())
                .name(department.getName())
                .build();

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Поиск департаментов по имени.
     * @param name Строка для поиска.
     * @param page Номер страницы.
     * @param size Кол-во записей.
     * @return
     *        Пейдженированная коллекция департаментов.
     */
    @ApiOperation(value = "Поиск департаментов по имени.",
            notes = "Поиск департамента по имени. Имя должно содержать не менее 5 символов. " +
                    "Если имя содержит менее 5 символов, запрос вернет пустой массив.",
            tags = {"Department service"} )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пейдженированная коллекция департаментов.", response = PagedDepartmentsDTO.class)
    })
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<PagedDepartmentsDTO> search(
            @ApiParam(value = "Строка для поиска.", defaultValue = "", type = "string") @RequestParam(value = "name",required = false ) String name,
            @ApiParam(value = "Номер страницы.",   defaultValue = "0", type = "int")    @RequestParam(value = "page", defaultValue = "0",required = false) int page,
            @ApiParam(value = "Кол-во записей.",   defaultValue = "5", type = "int")    @RequestParam(value = "size", defaultValue = "5",required = false) int size ){

        if (name.length() < NAME_MIN_LENGTH_TO_SEARCH){
            return new ResponseEntity<>( new PagedDepartmentsDTO(), HttpStatus.OK );
        }

        Page<Department> resultPage = repository
                .findTo10ByNameIgnoreCaseContainsOrderByName(name, new PageRequest(page,size));

        PagedDepartmentsDTO pagedDepartmentsDTO = new PagedDepartmentsDTO();
        pagedDepartmentsDTO.setElements(resultPage.getContent()
                .stream()
                .map(department -> new DepartmentDTO(department.getId().toString(), department.getName())).collect(Collectors.toList()));
        pagedDepartmentsDTO.setCurrentPage(page);
        pagedDepartmentsDTO.setPageSize(size);
        pagedDepartmentsDTO.setTotalElements(resultPage.getTotalElements());
        pagedDepartmentsDTO.setTotalPages(resultPage.getTotalPages());

        return new ResponseEntity<>(pagedDepartmentsDTO, HttpStatus.OK);
    }
}
