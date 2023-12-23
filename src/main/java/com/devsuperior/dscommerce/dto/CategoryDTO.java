package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Category;

public record CategoryDTO(
        Long id,
        String name
) {
    public CategoryDTO(Category category) {
        this(category.getId(), category.getName());
    }
}
