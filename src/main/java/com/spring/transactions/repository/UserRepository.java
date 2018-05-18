package com.spring.transactions.repository;

import com.spring.transactions.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends JpaRepository<User, Long> {
}
