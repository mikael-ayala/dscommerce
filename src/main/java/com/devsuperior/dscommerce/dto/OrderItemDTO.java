package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;

public record OrderItemDTO(
        Long productId,
        String name,
        Double price,
        Integer quantity,
        String imgUrl
) {
    public OrderItemDTO(OrderItem orderItem) {
        this(orderItem.getProduct().getId(),
            orderItem.getProduct().getName(),
            orderItem.getPrice(),
            orderItem.getQuantity(),
            orderItem.getProduct().getImgUrl()
        );
    }

    public Double getSubTotal() {
        return price * quantity;
    }
}
