package org.ricramiel.javalaboratory.repository.specifications;

import jakarta.persistence.criteria.Join;
import org.ricramiel.javalaboratory.model.api.SchedulePeriod;
import org.ricramiel.javalaboratory.model.api.ScheduleSlot;
import org.ricramiel.javalaboratory.model.enums.SlotType;
import org.ricramiel.javalaboratory.model.enums.SortDirection;
import org.ricramiel.javalaboratory.model.enums.SortFields;
import org.springframework.data.jpa.domain.Specification;

public class PeriodSpecifications {
    public static Specification<SchedulePeriod> filterById(String id) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id));
    }

    public static Specification<SchedulePeriod> filterBySlotId(String slotId) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("slot"), slotId));
    }

    public static Specification<SchedulePeriod> filterByScheduleId(String scheduleId) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("schedule"), scheduleId));
    }

    public static Specification<SchedulePeriod> filterBySlotType(SlotType slotType) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("slot_type"), slotType));
    }

    public static Specification<SchedulePeriod> filterByAdministratorId(String administratorId) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("administrator"), administratorId));
    }

    public static Specification<SchedulePeriod> filterByExecutorId(String executorId) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("executor"), executorId));
    }

    public static Specification<SchedulePeriod> sortByFieldAndOrderBy(SortFields field, SortDirection direction) {
        return (root, query, criteriaBuilder) -> {
            Join<SchedulePeriod, ScheduleSlot> scheduleJoin = root.join("slot");
            System.out.println(field.toString());
            if ("asc".equalsIgnoreCase(direction.toString())) {
                query.orderBy(criteriaBuilder.asc(scheduleJoin.get(field.toString())));
            } else {
                query.orderBy(criteriaBuilder.desc(scheduleJoin.get(field.toString())));
            }

            return null;
        };
    }
//    public static Specification<SchedulePeriod> sortByBeginTime() {}
}
