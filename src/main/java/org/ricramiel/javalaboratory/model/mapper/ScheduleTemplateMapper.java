package org.ricramiel.javalaboratory.model.mapper;

import org.ricramiel.javalaboratory.model.api.ScheduleTemplate;
import org.ricramiel.javalaboratory.model.dto.ScheduleTemplateDto;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTemplateMapper {
    public ScheduleTemplate toModel(ScheduleTemplateDto model) {
        ScheduleTemplate template = new ScheduleTemplate();
        template.setTemplate_type(model.getType());
        return template;
    }
}
