package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Product;
import jakarta.validation.constraints.*;

import java.util.List;

public record ProductDTO(
        Long id,
        @Size(min = 3, max = 80, message = "O campo deve ter entre 3 e 80 caracteres.")
        @NotBlank(message = "O campo não deve estar vazio.")
        String name,
        @Size(min = 10, message = "O campo deve ter pelo menos 10 caracteres.")
        @NotBlank(message = "O campo não deve estar vazio.")
        String description,
        @NotNull(message = "O campo não pode estar vazio.")
        @Positive(message = "O campo deve ser positivo.")
        Double price,
        String imgUrl,
        @NotEmpty(message = "O campo precisa de pelo menos uma categoria.")
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
