package com.hmaker.itembank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmaker.itembank.entity.Role;

public interface RoleJpaRepository extends JpaRepository<Role, Long> {
  Optional<List<Role>> findByUsername(String username);
}
