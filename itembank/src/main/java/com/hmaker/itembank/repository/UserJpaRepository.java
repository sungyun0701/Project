package com.hmaker.itembank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmaker.itembank.entity.User;

public interface UserJpaRepository extends JpaRepository<User, String> {

}
