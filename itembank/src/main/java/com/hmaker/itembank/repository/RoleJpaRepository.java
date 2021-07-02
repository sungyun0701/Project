package com.hmaker.itembank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hmaker.itembank.entity.Role;

public interface RoleJpaRepository extends JpaRepository<Role, Long> {
  Optional<List<Role>> findByUsername(String username);
  @Query(value = "SELECT id FROM role as r WHERE r.username = :username" , nativeQuery = true)
  Long findId(String username);
}
