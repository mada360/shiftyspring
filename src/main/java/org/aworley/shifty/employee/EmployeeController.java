package org.aworley.shifty.employee;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by adam on 16/02/17.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public List getEmployees(){
        return employeeService.getAllEmployees();
    }

    @RequestMapping(method = POST)
    //@ResponseStatus(HttpStatus.CREATED)
    //@ResponseBody
    public String addEmployee(@RequestBody Employee employee){
        employee.setStartDate(new Date());
        employeeService.addEmployee(employee);
        return "Employee Added";
        //return employee;
    }

    @RequestMapping(value = "/{id}", method = PUT)
    //@ResponseStatus(HttpStatus.OK)
    public String replaceEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employeeService.editEmployee(id, employee);
        return "Employee updated";
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public String removeEmployee(@PathVariable Long id){
        employeeService.removeEmployee(id);
        return "Employee deleted";
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }





}