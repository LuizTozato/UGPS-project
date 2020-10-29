package com.ugps.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ugps.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
