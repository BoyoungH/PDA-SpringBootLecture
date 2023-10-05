package com.example.springbootlecture.repository;

import com.example.springbootlecture.domain.entity.Movie;
import com.example.springbootlecture.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
