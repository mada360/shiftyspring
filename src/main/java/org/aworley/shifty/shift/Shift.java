package org.aworley.shifty.shift;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.aworley.shifty.employee.Employee;
import org.aworley.shifty.employee.EmployeeController;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by adam on 16/02/17.
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Shift extends ResourceSupport{

    private @Id @GeneratedValue  Long shiftId;
    @NonNull private String day;
    @NonNull private String time;

    @ManyToMany
    Employee employee;

    private @Version
    @JsonIgnore  Long version;

}
