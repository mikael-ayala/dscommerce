package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.List;

public record OrderDTO(
        Long id,
        Instant moment,
        OrderStatus status,
        ClientDTO client,
        PaymentDTO payment,
        @NotEmpty(message = "A lista de itens precisa ter pelo menos um item.")
        List<OrderItemDTO> items
) {
    public OrderDTO(Order order) {
        this(order.getId(),
            order.getMoment(),
            order.getStatus(),
            new ClientDTO(order.getClient()),
            (order.getPayment() == null) ? null : new PaymentDTO(order.getPayment()),
            order.getItems().stream().map(OrderItemDTO::new).toList()
        );
    }

    public Double getTotal() {
        double sum = 0.0;
        for (OrderItemDTO item : items) {
            sum += item.getSubTotal();
        }
        return sum;
    }
}
