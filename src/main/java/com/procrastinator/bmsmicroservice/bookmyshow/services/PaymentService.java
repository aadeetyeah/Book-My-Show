package com.procrastinator.bmsmicroservice.bookmyshow.services;

import com.procrastinator.bmsmicroservice.bookmyshow.model.Order;
import com.procrastinator.bmsmicroservice.bookmyshow.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private OrderRepository orderRepository;
}
