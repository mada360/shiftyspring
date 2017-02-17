package something.employee;

import lombok.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;


import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;

/**
 * Created by adam on 16/02/17.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee extends ResourceSupport{

    @NonNull @Generated @Id  private long employeeId;
    @NonNull private String firstName;
    @NonNull private String lastName;
    @NonNull private Date   startDate;

    //@ManyToMany
    //Shift shift;



}
