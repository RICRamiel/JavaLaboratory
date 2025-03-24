package org.ricramiel.javalaboratory.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ricramiel.javalaboratory.model.enums.SlotType;
import org.springframework.lang.Nullable;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulePeriodFilteredDto {
    @Nullable
    private SlotType slotType;
    @Nullable
    private String administratorId;
    @Nullable
    private String executorId;
    @Nullable
    private Instant beginTime;
    @Nullable
    private Instant endTime;
}
