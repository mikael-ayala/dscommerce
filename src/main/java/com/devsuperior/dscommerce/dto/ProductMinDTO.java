package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Product;

public record ProductMinDTO(
        Long id,
        String name,
        Double price,
        String imgUrl
) {
    public ProductMinDTO(Product product) {
        this(product.getId(), product.getName(), product.getPrice(), product.getImgUrl());
    }
}
