package org.aworley.shifty.employee;


import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by adam on 17/02/2017.
 */
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}
