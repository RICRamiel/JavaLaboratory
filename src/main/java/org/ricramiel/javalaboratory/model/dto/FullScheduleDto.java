package org.ricramiel.javalaboratory.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ricramiel.javalaboratory.model.api.Schedule;
import org.ricramiel.javalaboratory.model.api.SchedulePeriod;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullScheduleDto {
    private Schedule schedule;
    private List<SchedulePeriod> periods;
}
