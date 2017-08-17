package com.thewhite.sstuapp.web.rest;

import com.thewhite.sstuapp.domain.Department;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tupichkindenis on 15.08.17.
 */
@RestController
@RequestMapping("/departments")
public class DepartmentResource {
    @ApiOperation(value = "Some name of method", tags = {"Department service"}, nickname = "someNickName")
    @RequestMapping(value = "/custom", method = RequestMethod.POST)
    public Department custom() {
        return new Department();
    }
}
