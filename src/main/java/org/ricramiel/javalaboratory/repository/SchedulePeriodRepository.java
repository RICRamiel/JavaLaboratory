package org.ricramiel.javalaboratory.repository;

import jakarta.validation.constraints.NotNull;
import org.ricramiel.javalaboratory.model.api.Employee;
import org.ricramiel.javalaboratory.model.api.SchedulePeriod;
import org.ricramiel.javalaboratory.model.api.ScheduleSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchedulePeriodRepository extends JpaRepository<SchedulePeriod, String>, JpaSpecificationExecutor<SchedulePeriod> {

    public Optional<SchedulePeriod> findByAdministratorAndSlot(@NotNull Employee administrator, @NotNull ScheduleSlot slot);

    public Optional<SchedulePeriod> findByExecutorAndSlot(@NotNull Employee executor, @NotNull ScheduleSlot slot);

    public Optional<List<SchedulePeriod>> findAllByScheduleId(@NotNull String scheduleId);
}
