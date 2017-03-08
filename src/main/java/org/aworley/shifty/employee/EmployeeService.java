package org.aworley.shifty.employee;


import org.aworley.shifty.shift.Shift;
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

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    Employee getEmployee(Long id) {
        return employeeRepository.findOne(id);
    }

    void addEmployee(Employee employee) {

        employeeRepository.save(employee);
    }

    void editEmployee(Long id, Employee employee) {
        employeeRepository.save(employee);
    }

    void removeEmployee(Long id) {
        employeeRepository.delete(id);
    }

    Shift addShift(Shift shift){
        return shift;
    }
}
