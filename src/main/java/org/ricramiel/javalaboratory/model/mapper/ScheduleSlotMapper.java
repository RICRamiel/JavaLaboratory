package org.ricramiel.javalaboratory.model.mapper;

import org.ricramiel.javalaboratory.model.api.ScheduleSlot;
import org.ricramiel.javalaboratory.model.dto.ScheduleSlotDto;
import org.ricramiel.javalaboratory.repository.ScheduleTemplateRepository;
import org.springframework.stereotype.Component;

@Component
public class ScheduleSlotMapper {

    private final ScheduleTemplateRepository templateRepo;

    public ScheduleSlotMapper(ScheduleTemplateRepository templateRepo) {
        this.templateRepo = templateRepo;
    }

    public ScheduleSlot toModel(ScheduleSlotDto model) {
        ScheduleSlot slot = new ScheduleSlot();
        slot.setBegin_time(model.getBegin_time());
        slot.setEnd_time(model.getEnd_time());
        slot.setSchedule_template(templateRepo.getReferenceById(model.getTemplate_id()));
        return slot;
    }
}
