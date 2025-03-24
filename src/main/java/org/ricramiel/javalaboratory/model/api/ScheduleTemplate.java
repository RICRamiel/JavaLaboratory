package org.ricramiel.javalaboratory.model.api;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schedule_template")

public class ScheduleTemplate {

    @Id
    @Size(max = 32)
    private String id;

    @CreationTimestamp(source = SourceType.VM)
    private Instant creation_date;


    @NotBlank
    @Size(max = 2)
    private String template_type;

    @PrePersist
    public void ensureIdAssigned() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString().replace("-", "");
        }
    }
}
