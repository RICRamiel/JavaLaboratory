package org.ricramiel.javalaboratory.model.mapper;

import org.ricramiel.javalaboratory.model.dto.PaginationDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PaginationMapper {
    public <T> PaginationDto toDto(Page<T> domainPage) {
        return new PaginationDto(
                domainPage.getNumber(),
                domainPage.getSize(),
                domainPage.getTotalPages()
        );
    }
}
