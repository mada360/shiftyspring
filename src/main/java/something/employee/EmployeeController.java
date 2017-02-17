package something.employee;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.hateoas.jaxrs.JaxRsLinkBuilder.linkTo;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by adam on 16/02/17.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping
    public List getEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        for(Employee employee : allEmployees){
            Link selfLink = linkTo(EmployeeController.class).slash(employee.getEmployeeId()).withSelfRel();
            employee.add(selfLink);
        }
        return allEmployees;
    }

    @RequestMapping(method = POST)
    public Employee addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return employee;
    }

    @RequestMapping(value = "/{id}", method = PUT)
    public String replaceEmployee(@PathVariable long id, @RequestBody Employee employee){
        employeeService.editEmployee(id, employee);
        return "Shift replaced";
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public String removeEmployee(@PathVariable long id){
        employeeService.removeEmployee(id);
        return "Shift deleted";
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Employee getEmployee(@PathVariable long id) {
        return employeeService.getEmployee(id);
    }

}