package org.aworley.shifty.shift;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.aworley.shifty.employee.Employee;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by adam on 16/02/17.
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Shift extends ResourceSupport{

    private @Id @GeneratedValue  Long shiftId;
    @NonNull private String day;
    @NonNull private String time;

    @ManyToMany(mappedBy = "shifts")
    private Set<Employee> employees;

    private @Version
    @JsonIgnore  Long version;

}
