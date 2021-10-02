package com.procrastinator.bmsmicroservice.bookmyshow.repository;

import com.procrastinator.bmsmicroservice.bookmyshow.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
