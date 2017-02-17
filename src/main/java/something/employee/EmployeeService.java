package something.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by adam on 13/02/17.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public Employee getEmployee(long id) {
        return employeeRepository.findOne(id);
    }

    public void addEmployee(Employee employee) {
        employee.setStartDate(new Date());
        employeeRepository.save(employee);
    }

    public void editEmployee(long id, Employee employee) {
        employeeRepository.save(employee);
    }

    public void removeEmployee(long id) {
        employeeRepository.delete(id);
    }


}
