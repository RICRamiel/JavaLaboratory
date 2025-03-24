package org.ricramiel.javalaboratory.model.api;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "schedule_slot")
public class ScheduleSlot {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    private ScheduleTemplate schedule_template;

    @NotNull
    private Instant begin_time;

    @NotNull
    private Instant end_time;

    @PrePersist
    public void ensureIdAssigned() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString().replace("-", "");
        }
    }
}
