package org.aworley.shifty.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import org.aworley.shifty.shift.Shift;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by adam on 16/02/17.
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private @Id @GeneratedValue  Long employeeId;
    @NonNull private String firstName;
    @NonNull private String lastName;
    @NonNull private Date startDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_shifts")
    private Set<Shift> shifts = new HashSet<>();

    @Version @JsonIgnore private Long version;

}
