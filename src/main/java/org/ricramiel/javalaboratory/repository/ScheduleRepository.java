package org.ricramiel.javalaboratory.repository;

import org.ricramiel.javalaboratory.model.api.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {
    @Query("SELECT s from Schedule s where s.schedule_name = :name")
    Optional<Schedule> findBySchedule_name(@Param("name") String name);
}
