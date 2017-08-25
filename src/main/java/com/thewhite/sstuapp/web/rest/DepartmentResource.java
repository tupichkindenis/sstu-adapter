package com.thewhite.sstuapp.web.rest;

import com.thewhite.sstuapp.domain.Department;
import com.thewhite.sstuapp.repository.DepartmentRepository;
import com.thewhite.sstuapp.service.dto.department.DepartmentsCollectionDTO;
import com.thewhite.sstuapp.service.dto.department.DepartmentDTO;
import com.thewhite.sstuapp.service.dto.department.DepartmentsPagedCollectionDTO;
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
    @ApiOperation(  value   = "Получение департамента по идентификатору.",
                    notes   = "Подробная информация по департаменту.",
                    tags    = {"Department service"} )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Информация о департаменте", response = DepartmentDTO.class),
            @ApiResponse(code = 400, message = "Упс.", response = ApiError.class),
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
     * Получение списка департаментов
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(  value    = "Получение списка департаментов",
                    notes    = "Получение департаментов пейджинированным списком",
                    tags     = {"Department service"} )
    @ApiResponses(value = {
            @ApiResponse(
                    code     = 200,
                    message  = "Пейдженированная коллекция департаментов.",
                    response = DepartmentsPagedCollectionDTO.class)
    })
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity<DepartmentsPagedCollectionDTO> getAll(
            @RequestParam(value = "page", required = false, defaultValue =  "0")  int page,
            @RequestParam(value = "size", required = false, defaultValue = "20") int size ){

        Page<Department> departmentPage = repository.findAll(new PageRequest(page, size));

        DepartmentsPagedCollectionDTO departmentsPagedCollectionDTO = new DepartmentsPagedCollectionDTO();
        departmentsPagedCollectionDTO.setItems(departmentPage.getContent().stream().map( department -> DepartmentDTO.builder()
                .uuid(department.getId().toString())
                .name(department.getName())
                .build()).collect(Collectors.toList()));
        departmentsPagedCollectionDTO.setTotalElements(departmentPage.getTotalElements());
        departmentsPagedCollectionDTO.setTotalPages(departmentPage.getTotalPages());

        return new ResponseEntity<>(departmentsPagedCollectionDTO, HttpStatus.OK);

    }

    /**
     * Поиск департаментов по имени.
     * @param searchString Строка для поиска.
     * @return
     *        Пейдженированная коллекция департаментов.
     */
    @ApiOperation(  value = "Поиск департаментов по имени.",
                    notes = "Поиск департамента по имени. Имя должно содержать не менее 5 символов. Если имя содержит менее 5 символов, запрос вернет пустой массив. Метод возвращает не более 10 элементов.",
                    tags  = {"Department service"} )
    @ApiResponses(value = {
            @ApiResponse( code = 200,  message  = "Коллекция департаментов (не более 10).", response = DepartmentsPagedCollectionDTO.class)
    })
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<DepartmentsCollectionDTO> search(
            @ApiParam(value = "Строка поиска.", type = "string")
            @RequestParam(value = "name") String searchString ){

        if (searchString.length() < NAME_MIN_LENGTH_TO_SEARCH){
            return new ResponseEntity<>( new DepartmentsCollectionDTO(), HttpStatus.OK );
        }

        DepartmentsCollectionDTO departmentsCollectionDTO = new DepartmentsCollectionDTO();
        departmentsCollectionDTO.setItems(repository
                .findTo10ByNameIgnoreCaseContainsOrderByName(searchString)
                .stream()
                .map( department -> DepartmentDTO.builder()
                        .uuid(department.getId().toString())
                        .name(department.getName())
                        .build() )
                .collect(Collectors.toList()));

        return new ResponseEntity<>(departmentsCollectionDTO, HttpStatus.OK);
    }
}
