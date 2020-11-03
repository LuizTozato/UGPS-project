package com.ugps.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ugps.curso.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
