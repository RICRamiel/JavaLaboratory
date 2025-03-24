package org.ricramiel.javalaboratory.model.mapper;

import org.ricramiel.javalaboratory.model.api.SchedulePeriod;
import org.ricramiel.javalaboratory.model.dto.SchedulePeriodPageDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class SchedulePeriodPageMapper {
    private final SchedulePeriodMapper mapperSchedulePeriod;
    private final PaginationMapper mapperPagination;

    public SchedulePeriodPageMapper(SchedulePeriodMapper mapperSchedulePeriod, PaginationMapper mapperPagination) {
        this.mapperSchedulePeriod = mapperSchedulePeriod;
        this.mapperPagination = mapperPagination;
    }

    public SchedulePeriodPageDto toDto(Page<SchedulePeriod> schedulePeriod) {
        return new SchedulePeriodPageDto(mapperPagination.toDto(schedulePeriod), schedulePeriod.getContent().stream().map(mapperSchedulePeriod::toDto).toList());
    }
}
