package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
