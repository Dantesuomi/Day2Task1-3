package org.example.entity;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String name;
    private int employeeId;
    private String role;
    private int dateOfJoining;

    public Employee(EmployeeDto employeeDto) {
        this.name = employeeDto.getName();
        this.employeeId = employeeDto.getEmployeeId();
        this.role = employeeDto.getRole();
        this.dateOfJoining = (int)(System.currentTimeMillis() / 1000);
    }
}
