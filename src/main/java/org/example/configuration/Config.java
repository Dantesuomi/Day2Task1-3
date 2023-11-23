package org.example.configuration;

import org.example.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.GenericWebApplicationContext;

@Configuration
@ComponentScan(basePackages = "org.example")
public class Config extends GenericWebApplicationContext {

    @Bean
    public Employee employee() {

        //unix time
        int dateOfJoining = ((int)(System.currentTimeMillis()/1000));

        return new Employee("John Snow", 47565, "Party pooper", dateOfJoining);
    }

//    @Bean
//    public Employee employee(EmployeeDto employeeDto) {
//        Employee employee = new Employee();
//        employee.setEmployeeId(employeeDto.getEmployeeId());
//        employee.setName(employeeDto.getName());
//        employee.setRole(employeeDto.getRole());
//        employee.setDateOfJoining((int)(System.currentTimeMillis()/1000));
//        return employee;
//    }
}
