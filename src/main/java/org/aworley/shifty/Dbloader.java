package org.aworley.shifty;

import org.aworley.shifty.employee.Employee;
import org.aworley.shifty.employee.EmployeeRepository;
import org.aworley.shifty.shift.Shift;
import org.aworley.shifty.shift.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by adam on 09/03/2017.
 */
@Component
public class Dbloader implements CommandLineRunner{

    private final EmployeeRepository employeeRepository;
    private final ShiftRepository shiftRepository;

    @Autowired
    public Dbloader(EmployeeRepository employeeRepository, ShiftRepository shiftRepository){
        this.employeeRepository = employeeRepository;
        this.shiftRepository = shiftRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        Date date = new Date();


        this.employeeRepository.save(new Employee(null, "Adam", "Worley", date, null, null));
        this.employeeRepository.save(new Employee(null, "Jubal", "Harshaw", date, null, null));
        this.employeeRepository.save(new Employee(null, "Guy", "Montag", date, null, null));
        this.employeeRepository.save(new Employee(null, "John", "McClaine", date, null, null));
    }
}
