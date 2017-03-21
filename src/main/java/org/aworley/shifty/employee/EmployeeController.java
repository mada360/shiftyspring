package org.aworley.shifty.employee;

import org.aworley.shifty.shift.Shift;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;


import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by adam on 16/02/17.
 */
@RestController
public class EmployeeController{

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @RequestMapping(value = "/api/employees/{id}/shifts", method = GET  )
    public List<Shift> getShifts(@PathVariable Long id){
        return employeeService.getShifts(id);
    }


    @RequestMapping(value = "/api/employees/{id}/shifts", method = PUT  )
    public Shift addShift(@PathVariable Long id, @RequestBody Shift shift){
       return employeeService.addShift(id, shift);
    }

}