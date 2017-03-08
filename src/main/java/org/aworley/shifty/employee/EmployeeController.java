package org.aworley.shifty.employee;

import org.aworley.shifty.shift.Shift;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by adam on 16/02/17.
 */
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @RequestMapping("/api/employees")
    public List getEmployees(){
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/employees", method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee){
        if(employee.getStartDate() == null) {
            employee.setStartDate(new Date());
        }
        employeeService.addEmployee(employee);

        return employee;
    }

    @RequestMapping(value = "/employees/{id}", method = PUT)
    @ResponseStatus(HttpStatus.OK)
    public String replaceEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employeeService.editEmployee(id, employee);
        return "Shift updated";
    }

    @RequestMapping(value = "/employees/{id}", method = DELETE)
    public String removeEmployee(@PathVariable Long id){
        employeeService.removeEmployee(id);
        return "Employee deleted";
    }


    @RequestMapping(value = "/employees/{id}", method = GET)
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }


    @RequestMapping(value = "/api/employees/{id}/shifts", method = PUT  )
    public String addShift(@RequestBody Shift shift){
       return "Bum";
    }


}