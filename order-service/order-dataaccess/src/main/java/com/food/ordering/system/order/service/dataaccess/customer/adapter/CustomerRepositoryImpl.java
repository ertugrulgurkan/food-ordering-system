package com.food.ordering.system.order.service.dataaccess.customer.adapter;

import com.food.ordering.system.order.service.dataaccess.customer.mapper.CustomerDataAccessMapper;
import com.food.ordering.system.order.service.dataaccess.customer.repository.CustomerJpaRepository;
import com.food.ordering.system.order.service.domain.entity.Customer;
import com.food.ordering.system.order.service.domain.ports.output.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {
    private final CustomerDataAccessMapper customerDataAccessMapper;
    private final CustomerJpaRepository customerJpaRepository;

    public CustomerRepositoryImpl(CustomerDataAccessMapper customerDataAccessMapper, CustomerJpaRepository customerJpaRepository) {
        this.customerDataAccessMapper = customerDataAccessMapper;
        this.customerJpaRepository = customerJpaRepository;
    }

    @Override
    public Optional<Customer> findCustomer(UUID customerId) {
        return customerJpaRepository.findById(customerId)
                .map(customerDataAccessMapper::customerEntityToCustomer);
    }
}
