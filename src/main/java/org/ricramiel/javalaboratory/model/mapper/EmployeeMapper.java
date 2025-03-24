package org.ricramiel.javalaboratory.model.mapper;

import org.ricramiel.javalaboratory.model.api.Employee;
import org.ricramiel.javalaboratory.model.dto.EmployeeCUDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee toModel(EmployeeCUDto dto) {
        Employee employee = new Employee();
        employee.setEmployee_name(dto.getName());
        employee.setPosition(dto.getPosition());
        employee.setStatus(dto.getStatus());
        return employee;
    }
}
