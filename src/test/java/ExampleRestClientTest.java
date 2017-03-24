import org.aworley.shifty.employee.Employee;
import org.aworley.shifty.employee.EmployeeService;
import org.aworley.shifty.shift.Shift;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Created by adam on 24/03/2017.
 */
@RunWith(SpringRunner.class)
@RestClientTest(EmployeeService.class)
public class ExampleRestClientTest {

    @Autowired
    private EmployeeService service;

    @Autowired
    private MockRestServiceServer server;

    @Test
    public void getVehicleDetailsWhenResultIsSuccessShouldReturnDetails()
            throws Exception {
        this.server.expect(requestTo("/api/employees"))
                .andRespond(withSuccess("hello", MediaType.TEXT_PLAIN));
        List<Employee> greeting = this.service.addShift('Foo', 'Foo');
        assertThat(greeting).isEqualTo("hello");
    }


}