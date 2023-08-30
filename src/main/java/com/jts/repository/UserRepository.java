package com.jts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jts.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
