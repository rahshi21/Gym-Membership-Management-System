package com.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
