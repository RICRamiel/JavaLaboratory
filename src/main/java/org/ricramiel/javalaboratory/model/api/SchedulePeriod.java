package org.ricramiel.javalaboratory.model.api;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ricramiel.javalaboratory.model.enums.SlotType;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schedule_period")
public class SchedulePeriod {

    @Id
    private String id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Column(name = "schedule_id", insertable = false, updatable = false)
    private String scheduleId;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "slot_id")
    private ScheduleSlot slot;
    @Column(name = "slot_id", insertable = false, updatable = false)
    private String slotId;

    @Enumerated(EnumType.STRING)
    @NotNull
    private SlotType slot_type;

    @ManyToOne
    @JoinColumn(name = "administrator", referencedColumnName = "id")
    @NotNull
    private Employee administrator;

    @ManyToOne
    @JoinColumn(name = "executor", referencedColumnName = "id")
    private Employee executor;

    @PrePersist
    public void ensureIdAssigned() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString().replace("-", "");
        }
    }
}
