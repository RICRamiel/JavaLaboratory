package org.ricramiel.javalaboratory.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class SchedulePeriodPageDto {
    @NotNull
    PaginationDto paginationDto;

    @NotNull
    @Valid
    List<SchedulePeriodDto> schedulePeriods;
}
