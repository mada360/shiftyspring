package org.aworley.shifty.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import org.aworley.shifty.shift.Shift;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

/**
 * Created by adam on 16/02/17.
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends ResourceSupport{

    private @Id @GeneratedValue  Long employeeId;
    @NonNull private String firstName;
    @NonNull private String lastName;
    @NonNull private Date startDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "shifts")
    private Set<Shift> shifts;

    private @Version
    @JsonIgnore  Long version;

}
