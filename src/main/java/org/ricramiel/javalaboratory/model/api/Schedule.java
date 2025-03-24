package org.ricramiel.javalaboratory.model.api;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "schedule")

public class Schedule {

    @Id
    @Size(max = 32)

    private String id;

    @Size(max = 255)
    private String schedule_name;

    @CreationTimestamp(source = SourceType.VM)
    private Instant creation_date;


    @UpdateTimestamp(source = SourceType.VM)
    private Instant update_date;

    @PrePersist
    public void ensureIdAssigned() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString().replace("-", "");
        }
    }
}
