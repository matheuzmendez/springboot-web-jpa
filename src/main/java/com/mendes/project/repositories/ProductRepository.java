package com.mendes.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mendes.project.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
