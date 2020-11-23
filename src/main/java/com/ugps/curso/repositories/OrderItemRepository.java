package com.ugps.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ugps.curso.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
