package com.sharmokh.mongorecipeapp.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UnitOfMeasure {

    private Long id;
    private String description;

    @Builder
    public UnitOfMeasure(Long id, String description) {
        this.id = id;
        this.description = description;
    }
}
