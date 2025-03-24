package org.ricramiel.javalaboratory.model.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class ScheduleSlotDto {
    private Instant begin_time;
    private Instant end_time;
    private String template_id;
}
