package something.employee;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by adam on 17/02/2017.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
