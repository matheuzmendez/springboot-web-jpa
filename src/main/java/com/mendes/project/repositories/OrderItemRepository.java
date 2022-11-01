package com.mendes.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mendes.project.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
