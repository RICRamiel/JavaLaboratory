package org.ricramiel.javalaboratory.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ricramiel.javalaboratory.model.enums.SlotType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulePeriodDto {
    private String slot;
    private SlotType type;
    private String schedule;
    private String executor;
}
