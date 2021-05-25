package org.example.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class SearchApiRQDto {
    private String fromCode;
    private String toCode;
    private LocalDate departureDate;

}
