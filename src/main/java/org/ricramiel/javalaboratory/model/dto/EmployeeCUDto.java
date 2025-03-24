package org.ricramiel.javalaboratory.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ricramiel.javalaboratory.model.enums.EmployeePosition;
import org.ricramiel.javalaboratory.model.enums.EmployeeStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCUDto {
    private String name;
    private EmployeeStatus status;
    private EmployeePosition position;
}
