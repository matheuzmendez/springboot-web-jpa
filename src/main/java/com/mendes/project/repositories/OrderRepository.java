package com.mendes.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mendes.project.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
