package org.ricramiel.javalaboratory.repository;

import org.ricramiel.javalaboratory.model.api.ScheduleTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleTemplateRepository extends JpaRepository<ScheduleTemplate, String> {
}
