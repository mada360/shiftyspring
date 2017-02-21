package org.aworley.shifty.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

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

    private @Version
    @JsonIgnore  Long version;

}
