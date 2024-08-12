package com.gideon.btgpactual.service;


import com.gideon.btgpactual.entity.OrderEntity;
import com.gideon.btgpactual.entity.OrderItem;
import com.gideon.btgpactual.listener.dto.OrderCreatedEvent;
import com.gideon.btgpactual.repository.OrderRepositoy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepositoy orderRepositoy;

    public OrderService(OrderRepositoy orderRepositoy){
        this.orderRepositoy = orderRepositoy;
    }

    public void save(OrderCreatedEvent event){

        var entity = new OrderEntity();
        entity.setOrderId(event.codigoPedido());
        entity.setCostumerId(event.codigoCliente());


        entity.setItems(getOrderItems(event));
        entity.setTotal(getTotal(event));

        orderRepositoy.save(entity);
    }

    private BigDecimal getTotal(OrderCreatedEvent event) {
        return event.itens().stream()
                .map(i -> i.preco().multiply(BigDecimal.valueOf(i.quantidade())))
                .reduce( BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private static List<OrderItem> getOrderItems(OrderCreatedEvent event) {
        return event.itens().stream()
                .map(i -> new OrderItem(i.produto(), i.quantidade(), i.preco()))
                .toList();
    }
}
