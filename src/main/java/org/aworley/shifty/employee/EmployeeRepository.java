package org.aworley.shifty.employee;

import org.aworley.shifty.shift.Shift;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

/**
 * Created by adam on 17/02/2017.
 */

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> findByLastName(@Param("lastname") String name);

}
