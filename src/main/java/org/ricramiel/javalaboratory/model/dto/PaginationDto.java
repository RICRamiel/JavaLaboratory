package org.ricramiel.javalaboratory.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaginationDto {
    int page;
    int pageSize;
    int count;
}
