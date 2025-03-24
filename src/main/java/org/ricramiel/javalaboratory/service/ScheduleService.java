package org.ricramiel.javalaboratory.service;

import jakarta.annotation.Nullable;
import org.ricramiel.javalaboratory.model.api.Schedule;
import org.ricramiel.javalaboratory.model.api.SchedulePeriod;
import org.ricramiel.javalaboratory.model.api.ScheduleSlot;
import org.ricramiel.javalaboratory.model.api.ScheduleTemplate;
import org.ricramiel.javalaboratory.model.dto.*;
import org.ricramiel.javalaboratory.model.enums.SlotType;
import org.ricramiel.javalaboratory.model.mapper.ScheduleMapper;
import org.ricramiel.javalaboratory.model.mapper.SchedulePeriodMapper;
import org.ricramiel.javalaboratory.model.mapper.ScheduleSlotMapper;
import org.ricramiel.javalaboratory.model.mapper.ScheduleTemplateMapper;
import org.ricramiel.javalaboratory.repository.*;
import org.ricramiel.javalaboratory.repository.specifications.PeriodSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final ScheduleTemplateRepository scheduleTemplateRepository;
    private final ScheduleSlotRepository scheduleSlotRepository;
    private final SchedulePeriodRepository schedulePeriodRepository;
    private final ScheduleMapper scheduleMapper;
    private final ScheduleTemplateMapper scheduleTemplateMapper;
    private final ScheduleSlotMapper scheduleSlotMapper;
    private final SchedulePeriodMapper schedulePeriodMapper;
    private final EmployeeRepository employeeRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, ScheduleTemplateRepository scheduleTemplateRepository, ScheduleSlotRepository scheduleSlotRepository, SchedulePeriodRepository schedulePeriodRepository, ScheduleMapper scheduleMapper, ScheduleTemplateMapper scheduleTemplateMapper, ScheduleSlotMapper scheduleSlotMapper, SchedulePeriodMapper schedulePeriodMapper, EmployeeRepository employeeRepository) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleTemplateRepository = scheduleTemplateRepository;
        this.scheduleSlotRepository = scheduleSlotRepository;
        this.schedulePeriodRepository = schedulePeriodRepository;
        this.scheduleMapper = scheduleMapper;
        this.scheduleTemplateMapper = scheduleTemplateMapper;
        this.scheduleSlotMapper = scheduleSlotMapper;
        this.schedulePeriodMapper = schedulePeriodMapper;
        this.employeeRepository = employeeRepository;
    }

    public void createSchedule(ScheduleCUDto scheduleCUDto) {
        scheduleRepository.save(scheduleMapper.toModel(scheduleCUDto));
    }

    public void createTemplate(ScheduleTemplateDto templateDto) {
        scheduleTemplateRepository.save(scheduleTemplateMapper.toModel(templateDto));
    }

    public void createSlot(ScheduleSlotDto slotDto) {
        if (scheduleTemplateRepository.existsById(slotDto.getTemplate_id())) {
            scheduleSlotRepository.save(scheduleSlotMapper.toModel(slotDto));
        } else {
            //обработать исключение?
        }
    }

    public void createSchedulePeriod(SchedulePeriodDto schedulePeriodDto, String header) {
        if (schedulePeriodRepository.findByAdministratorAndSlot(employeeRepository.findById(header).get(), scheduleSlotRepository.getReferenceById(schedulePeriodDto.getSlot())).isEmpty() & schedulePeriodRepository.findByExecutorAndSlot(employeeRepository.getReferenceById(header), scheduleSlotRepository.getReferenceById(schedulePeriodDto.getSlot())).isEmpty()) {
            schedulePeriodRepository.save(schedulePeriodMapper.toModel(schedulePeriodDto, header));
        } else {
            //обработка ошибка
        }
    }

    public Schedule getSchedule(String id) {
        return scheduleRepository.findById(id).get();
    }

    public ScheduleTemplate getScheduleTemplate(String id) {
        return scheduleTemplateRepository.findById(id).get();
    }

    public ScheduleSlot getScheduleSlot(String id) {
        return scheduleSlotRepository.findById(id).get();
    }

    public SchedulePeriod getSchedulePeriod(String id) {
        return schedulePeriodRepository.findById(id).get();
    }


    //    public Page<SchedulePeriod> getFilteredSchedulePeriods(String id, String slotId, String scheduleId, SlotType slotType, String administratorId, String executorId, SortDirection sortDirection, SortFields sortFields, int pageIndex, int pageSize) {
//        String direction = sortDirection != null ? sortDirection.toString() : "asc";
//        String sortField = sortFields != null ? sortFields.name() : SortFields.begin_time.name();
//        Pageable pageable = PageRequest.of(pageIndex, pageSize);
//
//        Specification<SchedulePeriod> spec = Specification.where(null);
//        if (id != null) {
//            spec = spec.and(PeriodSpecifications.filterById(id));
//        }
//        if (slotId != null) {
//            spec = spec.and(PeriodSpecifications.filterBySlotId(slotId));
//        }
//        if (scheduleId != null) {
//            spec = spec.and(PeriodSpecifications.filterByScheduleId(scheduleId));
//        }
//        if (slotType != null) {
//            spec = spec.and(PeriodSpecifications.filterBySlotType(slotType));
//        }
//        if (administratorId != null) {
//            spec = spec.and(PeriodSpecifications.filterByAdministratorId(administratorId));
//        }
//        if (executorId != null) {
//            spec = spec.and(PeriodSpecifications.filterByExecutorId(executorId));
//        }
//        if (sortFields != null && sortDirection != null) {
//            spec = spec.and(PeriodSpecifications.sortByFieldAndOrderBy(SortFields.valueOf(sortField), SortDirection.valueOf(direction)));
//            Sort sort = Sort.by(direction, sortField);
//            pageable = PageRequest.of(pageIndex, pageSize, sort);
//        }
//        return schedulePeriodRepository.findAll(spec, pageable);
//    }
    public Page<SchedulePeriod> getFilteredSchedulePeriods(String id, String slotId, String scheduleId, SlotType slotType, String administratorId, String executorId, int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Specification<SchedulePeriod> spec = Specification.where(null);
        if (id != null) {
            spec = spec.and(PeriodSpecifications.filterById(id));
        }
        if (slotId != null) {
            spec = spec.and(PeriodSpecifications.filterBySlotId(slotId));
        }
        if (scheduleId != null) {
            spec = spec.and(PeriodSpecifications.filterByScheduleId(scheduleId));
        }
        if (slotType != null) {
            spec = spec.and(PeriodSpecifications.filterBySlotType(slotType));
        }
        if (administratorId != null) {
            spec = spec.and(PeriodSpecifications.filterByAdministratorId(administratorId));
        }
        if (executorId != null) {
            spec = spec.and(PeriodSpecifications.filterByExecutorId(executorId));
        }
        return schedulePeriodRepository.findAll(spec, pageable);
    }

    public FullScheduleDto getFullSchedule(@Nullable String id, @Nullable String name) {
        FullScheduleDto fullScheduleDto = new FullScheduleDto();
        if (id != null) {
            fullScheduleDto.setSchedule(scheduleRepository.findById(id).get());
            fullScheduleDto.setPeriods(schedulePeriodRepository.findAllByScheduleId(id).get());
        } else {
            Schedule schedule = scheduleRepository.findBySchedule_name(name).get();
            fullScheduleDto.setSchedule(schedule);
            fullScheduleDto.setPeriods(schedulePeriodRepository.findAllByScheduleId(schedule.getId()).get());
        }
        return fullScheduleDto;
    }
}
