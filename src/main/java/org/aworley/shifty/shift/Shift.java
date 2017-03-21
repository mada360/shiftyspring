package org.aworley.shifty.shift;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.aworley.shifty.employee.Employee;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.HashSet;
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

    private enum DAY {Monday, Tuesday, Wednesday, Thursday, Friday };
    private enum TIME {Morning, Afternoon, Evening};

    private @Id @GeneratedValue  Long shiftId;
    @NonNull private DAY shiftDay;
    @NonNull private TIME shiftTime;

    @ManyToMany(mappedBy = "shifts")
    //@JsonBackReference
    private Set<Employee> employees = new HashSet<>();

    private @Version  @JsonIgnore  Long version;

}
