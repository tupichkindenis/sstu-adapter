package com.thewhite.sstuapp.web.rest;

import com.thewhite.sstuapp.domain.Department;
import com.thewhite.sstuapp.repository.DepartmentRepository;
import com.thewhite.sstuapp.service.dto.DepartmentDTO;
import com.thewhite.sstuapp.service.dto.PagedDepartmentsDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


/**
 * Created by tupichkindenis on 15.08.17.
 */
@RestController
@RequestMapping("/departments")
public class DepartmentResource {

    @Autowired
    private DepartmentRepository repository;

    @ApiOperation(value = "Some name of method", tags = {"Department service"}, nickname = "someNickName")
    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public ResponseEntity<DepartmentDTO> getByUuid(@PathVariable(value = "uuid") final UUID uuid) {

        Department department = repository.findOne(uuid);

        if (department==null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        DepartmentDTO dto = DepartmentDTO.builder()
                .uuid(department.getId().toString())
                .name(department.getName())
                .build();

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<PagedDepartmentsDTO> search(
            @RequestParam(value = "name" ) String name,
            @RequestParam(value = "page", defaultValue = "0",required = false) int page,
            @RequestParam(value = "size", defaultValue = "5",required = false) int size ){

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
