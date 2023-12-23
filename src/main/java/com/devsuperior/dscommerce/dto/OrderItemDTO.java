package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;

public record OrderItemDTO(
        Long productId,
        String name,
        Double price,
        Integer quantity
) {
    public OrderItemDTO(OrderItem orderItem) {
        this(orderItem.getProduct().getId(),
            orderItem.getProduct().getName(),
            orderItem.getPrice(),
            orderItem.getQuantity());
    }

    public Double getSubTotal() {
        return price * quantity;
    }
}
