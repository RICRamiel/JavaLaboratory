package org.ricramiel.javalaboratory.model.mapper;

import org.ricramiel.javalaboratory.model.api.SchedulePeriod;
import org.ricramiel.javalaboratory.model.dto.SchedulePeriodDto;
import org.ricramiel.javalaboratory.repository.EmployeeRepository;
import org.ricramiel.javalaboratory.repository.ScheduleRepository;
import org.ricramiel.javalaboratory.repository.ScheduleSlotRepository;
import org.springframework.stereotype.Component;

@Component
public class SchedulePeriodMapper {
    private final EmployeeRepository employeeRepository;
    private final ScheduleSlotRepository scheduleSlotRepository;
    private final ScheduleRepository scheduleRepository;

    public SchedulePeriodMapper(EmployeeRepository employeeRepository, ScheduleSlotRepository scheduleSlotRepository, ScheduleRepository scheduleRepository) {
        this.employeeRepository = employeeRepository;
        this.scheduleSlotRepository = scheduleSlotRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public SchedulePeriod toModel(SchedulePeriodDto schedulePeriod, String headerUser) {
        SchedulePeriod newSchedulePeriod = new SchedulePeriod();
        newSchedulePeriod.setSlot_type(schedulePeriod.getType());
        newSchedulePeriod.setSchedule(scheduleRepository.getReferenceById(schedulePeriod.getSchedule()));
        newSchedulePeriod.setSlot(scheduleSlotRepository.getReferenceById(schedulePeriod.getSlot()));
        if (headerUser == schedulePeriod.getExecutor()) {
            newSchedulePeriod.setAdministrator(employeeRepository.getReferenceById(schedulePeriod.getExecutor()));
        } else {
            newSchedulePeriod.setAdministrator(employeeRepository.getReferenceById(headerUser));
            newSchedulePeriod.setExecutor(employeeRepository.getReferenceById(schedulePeriod.getExecutor()));

        }
        return newSchedulePeriod;
    }

    public SchedulePeriodDto toDto(SchedulePeriod schedulePeriod) {
        SchedulePeriodDto newSchedulePeriodDto = new SchedulePeriodDto();
        newSchedulePeriodDto.setExecutor(schedulePeriod.getExecutor().getId());
        newSchedulePeriodDto.setType(schedulePeriod.getSlot_type());
        newSchedulePeriodDto.setSlot(schedulePeriod.getSlotId());
        newSchedulePeriodDto.setSchedule(schedulePeriod.getScheduleId());
        return newSchedulePeriodDto;
    }
}
