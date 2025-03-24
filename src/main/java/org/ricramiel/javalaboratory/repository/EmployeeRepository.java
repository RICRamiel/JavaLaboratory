package org.ricramiel.javalaboratory.repository;

import org.ricramiel.javalaboratory.model.api.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
