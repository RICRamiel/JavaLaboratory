package org.ricramiel.javalaboratory.model.api;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ricramiel.javalaboratory.model.enums.EmployeePosition;
import org.ricramiel.javalaboratory.model.enums.EmployeeStatus;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @Size(max = 32)
    private String id;

    @NotNull
    @Size(max = 255)
    private String employee_name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EmployeePosition position;

    @PrePersist
    public void ensureIdAssigned() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString().replace("-", "");
        }
    }
}
