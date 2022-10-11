package com.food.ordering.system.order.service.dataaccess.customer.entitiy;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "order_customer_m_view", schema = "customer")
public class CustomerEntity {

    @Id
    private UUID id;
}
