//package org.ricramiel.advancedjavacontrol.service;
//
//
//import org.ricramiel.advancedjavacontrol.repository.EmployeeRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmployeeService {
//
//    private final EmployeeRepository employeeRepository;
//
//    public EmployeeService(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
//
//
//}
package org.ricramiel.javalaboratory.service;

import org.ricramiel.javalaboratory.model.api.Employee;
import org.ricramiel.javalaboratory.model.dto.EmployeeCUDto;
import org.ricramiel.javalaboratory.model.mapper.EmployeeMapper;
import org.ricramiel.javalaboratory.repository.*;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public void createEmployee(EmployeeCUDto employee) {
        employeeRepository.save(employeeMapper.toModel(employee));
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.getReferenceById(id);
    }
}