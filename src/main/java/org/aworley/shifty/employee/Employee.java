package org.aworley.shifty.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import org.aworley.shifty.shift.Shift;
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
public class Employee extends ResourceSupport{

    private @Id @GeneratedValue  Long employeeId;
    @NonNull private String firstName;
    @NonNull private String lastName;
    @NonNull private Date   startDate;

    @ManyToMany
    Shift shift;

    private @Version
    @JsonIgnore  Long version;

}
