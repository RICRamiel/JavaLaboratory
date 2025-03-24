package org.ricramiel.javalaboratory.model.mapper;

import org.ricramiel.javalaboratory.model.api.Schedule;
import org.ricramiel.javalaboratory.model.dto.ScheduleCUDto;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMapper {
    public Schedule toModel(ScheduleCUDto scheduleCUDto) {
        Schedule schedule = new Schedule();
        schedule.setSchedule_name(scheduleCUDto.getName());
        return schedule;
    }
}

