package org.aworley.shifty.employee;


import org.aworley.shifty.shift.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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


    Shift addShift(Long id, Shift shift){
        Employee employee = employeeRepository.findOne(id);
        Set<Shift> shiftSet = employee.getShifts();
        shiftSet.add(shift);
        employee.setShifts(shiftSet);
        return shift;
    }

    List<Shift> getShifts(Long id) {
        Employee employee = employeeRepository.findOne(id);
        Set<Shift> set = employee.getShifts();
        return new ArrayList<Shift>(set);
    }

}
