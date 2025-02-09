package com.example.Alfayomi.repo;

import com.example.Alfayomi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity , Long> {
    Optional<UserEntity> findByEmail(String email);
}
