package org.example.controller;

import org.example.entity.Employee;
import org.example.entity.EmployeeDto;
import org.example.entity.EmployeeEditDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private Map<Integer, Employee> employees = new HashMap<>();

    @GetMapping(value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Employee>> getAllEmployees() {
            List<Employee> employeeList = new ArrayList<>(employees.values());
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }

    @PostMapping(value = "/add",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDto employeeDto) {
        try {
            Employee employee = new Employee(employeeDto);
            employees.put(employee.getEmployeeId(), employee);

            return ResponseEntity.status(HttpStatus.CREATED).body(employee);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping(value = "/edit/{employeeId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> updateEmployee(@PathVariable int employeeId, @RequestBody EmployeeEditDto employeeEditDto) {
        try {
            if (employees.containsKey(employeeId)) {
                Employee existingEmployee = employees.get(employeeId);
                if(employeeEditDto.getName() != null){
                    existingEmployee.setName(employeeEditDto.getName());
                }
                if(employeeEditDto.getRole() != null){
                    existingEmployee.setRole(employeeEditDto.getRole());
                }
                employees.replace(employeeId, existingEmployee);
                return ResponseEntity.status(HttpStatus.OK).body(existingEmployee);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping (value = "/delete/{employeeId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteEmployee(@PathVariable int employeeId) {
            if (employees.containsKey(employeeId)) {
                Employee existingEmployee = employees.get(employeeId);
                employees.remove(employeeId);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }
}
