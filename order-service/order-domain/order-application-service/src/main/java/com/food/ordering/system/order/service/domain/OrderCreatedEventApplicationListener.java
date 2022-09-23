package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.service.domain.ports.output.message.publisher.payment.OrderCreatedPaymentRequestedMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public enum OrderCreatedEventApplicationListener {
    ;
    private final OrderCreatedPaymentRequestedMessagePublisher orderCreatedPaymentRequestedMessagePublisher;

    OrderCreatedEventApplicationListener(OrderCreatedPaymentRequestedMessagePublisher orderCreatedPaymentRequestedMessagePublisher) {
        this.orderCreatedPaymentRequestedMessagePublisher = orderCreatedPaymentRequestedMessagePublisher;
    }

    @TransactionalEventListener
    public void process(OrderCreatedEvent orderCreatedEvent){
        orderCreatedPaymentRequestedMessagePublisher.publish(orderCreatedEvent);
    }
}
