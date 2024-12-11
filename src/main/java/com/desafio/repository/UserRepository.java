package com.desafio.repository;


import com.desafio.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "SELECT COUNT(*) FROM users WHERE is_active = true", nativeQuery = true)
    int countActiveUsers();

    Optional<UserEntity> findByEmailAndIdNot(String email, Long id);

}
