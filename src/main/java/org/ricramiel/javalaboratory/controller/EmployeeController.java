package org.ricramiel.javalaboratory.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ricramiel.javalaboratory.model.api.Employee;
import org.ricramiel.javalaboratory.model.dto.EmployeeCUDto;
import org.ricramiel.javalaboratory.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@Tag(name = "Employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public void createEmployee(@RequestBody EmployeeCUDto employee) {
        employeeService.createEmployee(employee);
    }

    @GetMapping("/get/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }
}
