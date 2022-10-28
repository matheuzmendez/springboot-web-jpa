package com.mendes.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mendes.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
