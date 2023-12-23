package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.OrderItemPK;

public record OrderItemDTO(
        Long productId,
        String name,
        Double price,
        Integer quantity
) {
    public OrderItemDTO(OrderItem orderItem) {
        this(orderItem.getOrder().getId(),
            orderItem.getProduct().getName(),
            orderItem.getPrice(),
            orderItem.getQuantity());
    }

    public Double getSubTotal() {
        return price * quantity;
    }
}
