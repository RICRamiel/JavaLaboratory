package org.ricramiel.javalaboratory.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ricramiel.javalaboratory.model.api.Schedule;
import org.ricramiel.javalaboratory.model.api.SchedulePeriod;
import org.ricramiel.javalaboratory.model.api.ScheduleSlot;
import org.ricramiel.javalaboratory.model.api.ScheduleTemplate;
import org.ricramiel.javalaboratory.model.dto.*;
import org.ricramiel.javalaboratory.model.enums.SlotType;
import org.ricramiel.javalaboratory.model.mapper.SchedulePeriodPageMapper;
import org.ricramiel.javalaboratory.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
@Tag(name = "Schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final SchedulePeriodPageMapper schedulePeriodPageMapper;

    public ScheduleController(ScheduleService scheduleService, SchedulePeriodPageMapper schedulePeriodPageMapper) {
        this.scheduleService = scheduleService;
        this.schedulePeriodPageMapper = schedulePeriodPageMapper;
    }

    @GetMapping("/get/{id}")
    public Schedule getSchedule(@PathVariable String id) {
        return scheduleService.getSchedule(id);
    }

    @GetMapping("/template/get/{id}")
    public ScheduleTemplate getScheduleTemplate(@PathVariable String id) {
        return scheduleService.getScheduleTemplate(id);
    }

    @GetMapping("/slot/get/{id}")
    public ScheduleSlot getScheduleSlot(@PathVariable String id) {
        return scheduleService.getScheduleSlot(id);
    }

    @GetMapping("/period/get/{id}")
    public SchedulePeriod getSchedulePeriod(@PathVariable String id) {
        return scheduleService.getSchedulePeriod(id);
    }

    @PostMapping("/create")
    public void createSchedule(@RequestBody ScheduleCUDto schedule) {
        scheduleService.createSchedule(schedule);
    }

    @PostMapping("/slot/create")
    public void createScheduleSlot(@RequestBody ScheduleSlotDto slot) {
        scheduleService.createSlot(slot);
    }

    @PostMapping("/template/create")
    public void createScheduleTemplate(@RequestBody ScheduleTemplateDto schedule) {
        scheduleService.createTemplate(schedule);
    }

    @PostMapping("/period/create")
    public void createSchedulePeriod(@RequestBody SchedulePeriodDto periodDto, @RequestHeader("x-current-user") String header) {
        scheduleService.createSchedulePeriod(periodDto, header);
    }

    // НЕ СМОГ ПОНЯТЬ КАК ИСПОЛЬЗОВАТЬ СПЕЦИФИКАЦИИ ДЛЯ СОРТИРОВКИ
//    @GetMapping("/period/filter")
//    public SchedulePeriodPageDto getSchedulePeriodFilter(@RequestParam(required = false) String id, @RequestParam(required = false) String slotId, @RequestParam(required = false) String scheduleId, @RequestParam(required = false) SlotType slotType, @RequestParam(required = false) String administratorId, @RequestParam(required = false) String executorId, @RequestParam(required = false, defaultValue = "0") int pageIndex, @RequestParam(required = false, defaultValue = "10") int pageSize, @RequestParam(required = false) SortDirection sortDirection, @RequestParam(required = false) SortFields sortFields) {
//        return schedulePeriodPageMapper.toDto(scheduleService.getFilteredSchedulePeriods(id, slotId, scheduleId, slotType, administratorId, executorId, sortDirection, sortFields, pageIndex, pageSize));
//    }
    @GetMapping("/period/filter")
    public SchedulePeriodPageDto getSchedulePeriodFilter(@RequestParam(required = false) String id, @RequestParam(required = false) String slotId, @RequestParam(required = false) String scheduleId, @RequestParam(required = false) SlotType slotType, @RequestParam(required = false) String administratorId, @RequestParam(required = false) String executorId, @RequestParam(required = false, defaultValue = "0") int pageIndex, @RequestParam(required = false, defaultValue = "10") int pageSize) {
        return schedulePeriodPageMapper.toDto(scheduleService.getFilteredSchedulePeriods(id, slotId, scheduleId, slotType, administratorId, executorId, pageIndex, pageSize));
    }

    @GetMapping("/getFull")
    public FullScheduleDto getFullSchedule(@RequestParam(required = false) String id, @RequestParam(required = false) String name) {
        return scheduleService.getFullSchedule(id, name);
    }
}
