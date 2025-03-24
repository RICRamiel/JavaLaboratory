package org.ricramiel.javalaboratory.repository;

import org.ricramiel.javalaboratory.model.api.ScheduleSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleSlotRepository extends JpaRepository<ScheduleSlot, String> {
}
