package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Category;
import com.devsuperior.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;

public record ProductDTO(
        Long id,
        @Size(min = 3, max = 80, message = "O campo nome deve ter entre 3 e 80 caracteres.")
        @NotBlank(message = "O campo nome não deve estar vazio.")
        String name,
        @Size(min = 10, message = "O campo descrição deve ter pelo menos 10 caracteres.")
        @NotBlank(message = "O campo descrição não deve estar vazio.")
        String description,
        @Positive(message = "O campo valor deve ser positivo.")
        Double price,
        String imgUrl,
        @NotEmpty(message = "O produto precisa de pelo menos uma categoria.")
        List<CategoryDTO> categories
) {
    public ProductDTO(Product product) {
        this(product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getImgUrl(),
            product.getCategories().stream().map(cat -> new CategoryDTO(cat.getId(), cat.getName())).toList());
    }
}
